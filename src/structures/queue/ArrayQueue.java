package structures.queue;


public class ArrayQueue<T> implements Queue<T> {
    // The minimum capacity that we'll use for a newly created queue
    private final int defaultCapacity = 8;
    // The array in which the elements of the queue are stored
    T[] queue;
    // The index of the element at the head of the queue
    private int head;
    // The index at which the next element would be added to the tail of the
    // queue
    private int tail;
    private int size;

    public ArrayQueue() {
        // Allocate empty array to hold the defaultCapacity number of elements.
        this.queue = (T[]) new Object[defaultCapacity];
    }

    public ArrayQueue(int initialCapacity) {
        // Allocate empty array to hold the initialCapacity number of elements.
        this.queue = (T[]) new Object[initialCapacity];
    }

    private void stretch() {
        T[] oldQueue = this.queue;
        this.queue = (T[]) new Object[oldQueue.length + 16];
        for (int i = 0; i < size; i++) {
            queue[i] = oldQueue[head];
            head++;
            if (head >= oldQueue.length) {
                head = 0;
            }
        }
        head = 0;
        tail = size ;
    }

    private int increment(int val) {
        val++;
        if (val >= queue.length) {
            val = 0;
        }
        return val;
    }

    @Override
    public boolean enqueue(T e) {
        if (e == null) return false;
        if (size == queue.length) {
            stretch();
        }
        queue[tail] = e;
        tail = increment(tail);
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;

        T e = queue[head];
        queue[head] = null;
        head = increment(head);
        size--;
        return e;
    }

    @Override
    public T head() {
        if (isEmpty()) {
            return null;
        } else {
            return queue[head];
        }
    }

    @Override
    public int size() {
        return size;
    }

}

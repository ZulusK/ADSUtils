package structures.deque;

public class ArrayDeque<T> implements Deque<T> {
    // The minimum capacity that we'll use for a newly created deque
    private final int defaultCapacity = 8;
    // The array in which the elements of the deque are stored.
    T[] queue;
    // The index of the element at the head of the deque
    private int head;
    // The index at which the next element would be added to the tail of the
    // deque
    private int tail;

    private int size;

    public ArrayDeque() {
        this.queue = (T[]) new Object[defaultCapacity];
    }

    private void stretch() {
        T[] oldQueue = this.queue;
        this.queue = (T[]) new Object[oldQueue.length + 16];
        for (int i = 0; i < size; i++) {
            head++;
            if(head>=oldQueue.length){
                head=0;
            }
            queue[i] = oldQueue[head];
        }
        head = queue.length-1;
        tail = size - 1;
    }

    @Override
    public boolean addFirst(T e) {
        if (e == null) {
            return false;
        }
        if (size == queue.length) {
            stretch();
        }
        queue[head] = e;
        head = decrement(head);
        size++;
        return true;
    }

    @Override
    public boolean addLast(T e) {
        if (e == null) {
            return false;
        }
        if (size == queue.length) {
            stretch();
        }
        tail = increment(tail);
        queue[tail] = e;
        size++;
        return true;
    }


    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        head = increment(head);
        T e = queue[head];
        queue[head] = null;
        size--;
        return e;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T e = queue[tail];
        queue[tail] = null;
        tail = decrement(tail);
        size--;
        return e;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return queue[increment(head)];
    }

    private int increment(int val) {
        val++;
        if (val >= this.queue.length) {
            val = 0;
        }
        return val;
    }

    private int decrement(int val) {
        val--;
        if (val < 0) {
            val = queue.length - 1;
        }
        return val;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return queue[tail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}

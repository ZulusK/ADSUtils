package structures.list;


public class ArrayList<T> implements List<T> {
    // Default initial capacity
    private final int defaultCapacity = 10;
    private T[] list;
    // the size of the array used to store the elements in the list
    private int capacity;

    // The size of the ArrayList (the number of elements it contains)
    private int size;

    /**
     * Constructs an empty list with an initial capacity of ten
     */
    public ArrayList() {
        this.capacity = defaultCapacity;
        this.list = (T[]) new Object[capacity];
    }

    /**
     * Constructs an empty list with the specified initial capacity
     *
     * @param initialCapacity the initial capacity of the list
     */
    public ArrayList(int initialCapacity) {
        this.capacity = initialCapacity;
        this.list = (T[]) new Object[capacity];
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        if (size == capacity) {
            resize();
        }
        this.list[size++] = element;
        return true;
    }

    private void resize() {
        T[] oldList = this.list;
        capacity += 16;
        this.list = (T[]) new Object[capacity];
        System.arraycopy(oldList, 0, list, 0, oldList.length);
    }

    /**
     * shift elements to right
     *
     * @param index
     */
    private void shiftRight(int index) {
        for (int i = index + 1; i <= size; i++) {
            list[i] = list[i - 1];
        }
    }

    /**
     * shift elements to left
     *
     * @param index
     */
    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
    }

    @Override
    public boolean add(int index, T e) {
        if (index < 0 || index > size || e == null) {
            return false;
        }
        if (size == capacity) {
            resize();
        }
        shiftRight(index);
        this.list[index] = e;
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            T element = list[index];
            shiftLeft(index);
            size--;
            return element;
        }
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return list[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            return null;
        }
        T oldElement = list[index];
        list[index] = element;
        return oldElement;
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

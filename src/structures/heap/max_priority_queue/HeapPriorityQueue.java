package structures.heap.max_priority_queue;

import structures.heap.Heap;
import structures.heap.MaxPriorityQueue;
import structures.list.ArrayList;

public class HeapPriorityQueue<T extends Comparable> implements MaxPriorityQueue<T>, Heap {
    private ArrayList<T> heap;

    /**
     * Creates a PriorityQueue with the default initial capacity and whose
     * elements are ordered according to the specified comparator.
     */

    public HeapPriorityQueue() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(T e) {
        if (e != null) {
            // Inserts the specified element s into heap
            heap.add(e);
            swim(heap.size() - 1);
        }
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public T removeMax() {
        if (isEmpty()) {
            return null;
        }
        T data = heap.get(0);
        if (heap.size() > 1) {
            heap.set(0, heap.get(heap.size() - 1));
            sink(0);
        }
        heap.remove(heap.size() - 1);
        return data;
    }

    @Override
    public T max() {
        return heap.get(0);
    }

    @Override
    public int size() {
        return heap.size();
    }

    private void swap(int a, int b) {
        T aval = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, aval);
    }

    @Override
    public void swim(int index) {
        if (index >= 0 && index < heap.size()) {
            int parent = getParent(index);
            if (heap.get(parent).compareTo(heap.get(index)) < 0) {
                swap(parent, index);
                swim(parent);
            }
        }
    }

    @Override
    public void sink(int index) {
        T curr = heap.get(index);
        if (curr != null) {
            int left = getLeft(index);
            int right = getRight(index);
            int largest = index;
            if (left < heap.size() && curr.compareTo(heap.get(left)) < 0) {
                largest = left;
                curr=heap.get(largest);
            }
            if (right < heap.size() && curr.compareTo(heap.get(right)) < 0) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                sink(largest);
            }
        }
    }

    @Override
    public int getParent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public int getLeft(int i) {
        return i * 2+1;
    }

    @Override
    public int getRight(int i) {
        return getLeft(i) + 1;
    }

}

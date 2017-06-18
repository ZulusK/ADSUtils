package structures.heap.max_priority_queue;

import structures.heap.MaxPriorityQueue;
import structures.list.ArrayList;

public class UnsortedArrayPriorityQueue<T extends Comparable> implements MaxPriorityQueue<T> {
    private ArrayList<T> array;

    public UnsortedArrayPriorityQueue() {
        array = new ArrayList<>();
    }

    private int getMaxPos() {
        T max = array.get(0);
        int index = 0;
        for (int i = 0; i < array.size(); i++) {
            T curr = array.get(i);
            if (curr.compareTo(max) > 0) {
                max = curr;
                index = i;
            }
        }
        return index;
    }

    @Override
    public void insert(T e) {
        array.add(e);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T removeMax() {
        return array.remove(getMaxPos());
    }

    @Override
    public T max() {
        return array.get(getMaxPos());
    }

    @Override
    public int size() {
        return array.size();
    }

}

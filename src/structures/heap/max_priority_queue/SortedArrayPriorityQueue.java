package structures.heap.max_priority_queue;

import structures.heap.MaxPriorityQueue;
import structures.list.ArrayList;

public class SortedArrayPriorityQueue<T extends Comparable> implements MaxPriorityQueue<T> {
    private ArrayList<T> array;

    public SortedArrayPriorityQueue() {
        array = new ArrayList<>();
    }

    @Override
    public void insert(T e) {
        if (e == null) {
            return;
        }
        int index = 0;
        for (; index < array.size(); index++) {
            T curr = array.get(index);
            if (curr.compareTo(e) < 0) {
                break;
            }
        }
        array.add(index, e);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T removeMax() {
        return array.remove(0);
    }

    @Override
    public T max() {
        return array.get(0);
    }

    @Override
    public int size() {
        return array.size();
    }

}

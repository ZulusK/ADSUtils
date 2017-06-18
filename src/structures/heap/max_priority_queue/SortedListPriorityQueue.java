package structures.heap.max_priority_queue;

import structures.heap.MaxPriorityQueue;
import structures.list.DoublyLinkedList;

public class SortedListPriorityQueue<T extends Comparable> implements MaxPriorityQueue<T> {
    private DoublyLinkedList<T> list;

    public SortedListPriorityQueue() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public void insert(T e) {
        if (e == null) {
            return;
        }
        int index = 0;
        for (; index < list.size(); index++) {
            T curr = list.get(index);
            if (curr.compareTo(e) < 0) {
                break;
            }
        }
        list.add(index, e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T removeMax() {
        return list.remove(0);
    }

    @Override
    public T max() {
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

}

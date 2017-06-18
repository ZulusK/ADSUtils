package structures.heap.max_priority_queue;

import structures.heap.MaxPriorityQueue;
import structures.list.DoublyLinkedList;

public class UnsortedListPriorityQueue<T extends Comparable> implements MaxPriorityQueue<T> {
	private DoublyLinkedList<T> list;

	public UnsortedListPriorityQueue() {
		list = new DoublyLinkedList<>();
	}

	private int getMaxPos() {
		T max = list.get(0);
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			T curr = list.get(i);
			if (curr.compareTo(max) > 0) {
				max = curr;
				index = i;
			}
		}
		return index;
	}

	@Override
	public void insert(T e) {
		list.add(e);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public T removeMax() {
		return list.remove(getMaxPos());
	}

	@Override
	public T max() {
		return list.get(getMaxPos());
	}

	@Override
	public int size() {
		return list.size();
	}

}

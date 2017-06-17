package structures.queue;

import structures.SLNode;


public class LinkedQueue<T> implements Queue<T> {
    // Pointer to head (first node)
    private SLNode<T> head;

    // Pointer to tail (last node)
    private SLNode<T> tail;

    private int size;

    @Override
    public boolean enqueue(T e) {
        if (e == null) return false;
        SLNode<T> newNode = new SLNode<T>(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
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
        T data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public T head() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getData();
        }
    }

    @Override
    public int size() {
        return size;
    }

}

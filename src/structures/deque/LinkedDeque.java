package structures.deque;

import structures.DLNode;

public class LinkedDeque<T> implements Deque<T> {

    // Pointer to head (first node)
    private DLNode<T> head;

    // Pointer to tail (last node)
    private DLNode<T> tail;
    private int size;

    public LinkedDeque() {
        this.head = new DLNode<T>(null);
        this.tail = new DLNode<T>(null);
        head.setPrev(tail);
        head.setNext(tail);
        tail.setNext(head);
        tail.setPrev(head);
    }

    private void addAfter(DLNode<T> prev, T element) {
        DLNode<T> newNode = new DLNode<T>(element);
        newNode.setNext(prev.getNext());
        newNode.setPrev(prev);
        prev.getNext().setPrev(newNode);
        prev.setNext(newNode);
        size++;
    }

    @Override
    public boolean addFirst(T e) {
        if (e == null) {
            return false;
        }
        addAfter(head, e);
        return true;
    }

    @Override
    public boolean addLast(T e) {
        if (e == null) {
            return false;
        }
        addAfter(tail.getPrev(), e);
        return true;
    }

    private void removeAfter(DLNode<T> prev) {
        DLNode rmNode = prev.getNext();
        prev.setNext(rmNode.getNext());
        rmNode.getNext().setPrev(prev);

        rmNode.setData(null);
        rmNode.setNext(null);
        rmNode.setPrev(null);
        size--;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        DLNode<T> rmNode = head.getNext();
        T data = rmNode.getData();
        removeAfter(rmNode.getPrev());
        return data;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        DLNode<T> rmNode = tail.getPrev();
        T data = rmNode.getData();
        removeAfter(rmNode.getPrev());
        return data;
    }

    @Override
    public T getFirst() {
        if(isEmpty()) {
            return null;
        }else{
            return head.getNext().getData();
        }
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        } else {
            return tail.getPrev().getData();
        }
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

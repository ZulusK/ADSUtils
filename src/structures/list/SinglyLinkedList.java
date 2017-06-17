package structures.list;

import structures.SLNode;

public class SinglyLinkedList<T> implements List<T> {
    // Pointer to first node.
    private SLNode<T> first;
    private int size;

    private SLNode<T> getNode(int index) {
        SLNode<T> curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr;
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        SLNode<T> newNode = new SLNode<T>(element);
        if (first == null) {
            first = newNode;
        } else {
            getNode(size - 1).setNext(newNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (index < 0 || index > size || element == null) {
            return false;
        }
        SLNode<T> newNode = new SLNode<T>(element);
        if (index == 0) {
            newNode.setNext(first);
            first = newNode;
        } else {
            SLNode prev = getNode(index - 1);
            SLNode next = prev.getNext();
            newNode.setNext(next);
            prev.setNext(newNode);
        }
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        //data in node
        T data = null;
        //if remove head
        if (index == 0) {
            data = first.getData();
            first.setData(null);
            first = first.getNext();
        } else {
            //get prev node
            SLNode<T> prev = getNode(index - 1);
            data = prev.getNext().getData();
            prev.getNext().setData(null);
            prev.setNext(prev.getNext().getNext());
        }
        size--;
        return data;
    }

    @Override
    public boolean remove(T element) {
        if (element == null || isEmpty()) {
            return false;
        }
        //check, is head contains element
        if (first.getData().equals(element)) {
            first.setData(null);
            first = first.getNext();
            size--;
            return true;
        }
        //search for prev node, that contains element
        for (SLNode<T> curr = first; curr.getNext() != null; curr = curr.getNext()) {
            if (curr.getNext().getData().equals(element)) {
                curr.getNext().setData(null);
                curr.setNext(curr.getNext().getNext());
                size--;
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
        return getNode(index).getData();
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size || element == null) {
            return null;
        }
        SLNode<T> node = getNode(index);
        T data = node.getData();
        node.setData(element);
        return data;
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

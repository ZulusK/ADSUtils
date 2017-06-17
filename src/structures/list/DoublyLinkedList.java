package structures.list;

import structures.DLNode;

public class DoublyLinkedList<T> implements List<T> {
    // Pointer to first node
    private DLNode<T> first;

    // Pointer to last node
    private DLNode<T> last;

    private int size;

    public DoublyLinkedList() {
        this.first = new DLNode<T>(null);
        this.last = new DLNode<T>(null);
        this.first.setNext(last);
        this.first.setPrev(last);
        this.last.setNext(first);
        this.last.setPrev(first);
    }

    private DLNode<T> getNode(int index) {
        DLNode<T> curr = first.getNext();
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr;
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
    public boolean add(T element) {
        if (element == null) return false;
        addAfter(last.getPrev(), element);
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (index < 0 || index > size) return false;
        addAfter(getNode(index - 1), element);
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
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        DLNode<T> rmNode = getNode(index);
        T data = rmNode.getData();
        removeAfter(rmNode.getPrev());
        return data;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        for (DLNode<T> curr = first.getNext(); curr != last; curr = curr.getNext()) {
            if (curr.getData().equals(element)) {
                removeAfter(curr.getPrev());
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
        DLNode<T> node = getNode(index);
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

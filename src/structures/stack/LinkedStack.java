package structures.stack;

import structures.SLNode;

public class LinkedStack<T> implements Stack<T> {
    private SLNode<T> top;
    private int size;

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T e = top.getData();
            top = top.getNext();
            size--;
            return e;
        }
    }

    @Override
    public void push(T item) {
        if (item != null) {
            SLNode<T> newNode = new SLNode<T>(item);
            size++;
            newNode.setNext(top);
            top = newNode;
        }
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        } else {
            return top.getData();
        }
    }

    @Override
    public int size() {
        return size;
    }

}

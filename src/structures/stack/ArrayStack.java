package structures.stack;

public class ArrayStack<T> implements Stack<T> {
    private final int defaultCapacity = 20;
    private T[] stack;
    private int top;
    private int size;

    public ArrayStack() {
        this.stack = (T[]) new Object[defaultCapacity];
    }

    @Override
    public boolean isEmpty() {
        return stack[0] == null;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        top--;
        T e= stack[top];
        stack[top]=null;
        return e;
    }


    private void stretch() {
        T[] oldStack = this.stack;
        this.stack = (T[]) new Object[oldStack.length + 16];
        System.arraycopy(oldStack, 0, stack, 0, top);
    }


    @Override
    public void push(T item) {
        if (item != null) {
            if (top == stack.length) {
                stretch();
            }
            stack[top] = item;
            top++;
        }
    }

    @Override
    public T top() {
        if (isEmpty()) return null;
        return stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

}

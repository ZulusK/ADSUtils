package structures.stack;

public interface Stack<T> {

    /**
     * Tests if this stack is empty
     *
     * @return true if this stack contains no items; false otherwise
     */
    boolean isEmpty();

    /**
     * Removes the item at the top of this stack and returns that item as the
     * value of this function.
     *
     * @return the object at the top of this stack or empty T if this stack
     * is empty
     */
    T pop();

    /**
     * Adds an item onto the top of this Stack
     *
     * @param item the item to be pushed onto this stack
     */
    void push(T item);

    /**
     * Looks at the object at the top of this stack without removing it from the
     * stack
     *
     * @return the top element in the stack, or null if the stack is empty.
     **/
    T top();

    /**
     * Returns the number of elements in this stack
     *
     * @return the number of elements in the stack
     */
    int size();

}
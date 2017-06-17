package structures.deque;


public interface Deque<T> {

    /**
     * Inserts the specified element at the front of this deque if it is
     * possible
     *
     * @param e the element to add
     * @return true if this queue changed as a result of the call
     */
    boolean addFirst(T e);

    /**
     * Inserts the specified element at the end of this deque if it is possible
     *
     * @param e the element to add
     * @return true if this queue changed as a result of the call
     */
    boolean addLast(T e);

    /**
     * Retrieves and removes the first element of this deque
     *
     * @return the head of this deque or empty T if this queue is empty
     */
    T removeFirst();

    /**
     * Retrieves and removes the last element of this deque if it is possible
     *
     * @return the tail of this deque or empty T if this queue is empty
     */
    T removeLast();

    /**
     * Retrieves, but not removes, the first element of this deque
     *
     * @return the head of this deque or empty T if this queue is empty
     */
    T getFirst();

    /**
     * Retrieves, but not removes, the last element of this deque
     *
     * @return the tail of this deque or empty T if this queue is empty
     */
    T getLast();

    /**
     * Returns the number of elements in this queue
     *
     * @return the number of elements in this queue
     */
    int size();

    /**
     * Returns true if this deque contains no elements.
     *
     * @return true if this deque contains no elements
     */
    boolean isEmpty();

}

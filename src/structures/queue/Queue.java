package structures.queue;

public interface Queue<T> {

    /**
     * Insert element e at the tail of the queue
     *
     * @param e the element to add
     * @return true if this queue changed as a result of the call
     */
    public boolean enqueue(T e);

    /**
     * Retrieves and removes the head of this queue
     *
     * @return the head of this queue or empty T
     */
    public T dequeue();

    /**
     * Retrieves, but does not remove, the head of this queue
     *
     * @return the head of this queue, or empty T if this queue is empty
     */
    public T head();

    /**
     * Returns the number of elements in this queue
     *
     * @return the number of elements in this queue
     */
    public int size();

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue contains no elements
     */
    public boolean isEmpty();

}

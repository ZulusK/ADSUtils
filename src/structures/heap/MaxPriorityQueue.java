package structures.heap;

public interface MaxPriorityQueue<T extends Comparable> {
    /**
     * insert new element into max-priority queue
     *
     * @param e the T 's object to insert
     */
    public void insert(T e);

    /**
     * test the whether max-priority queue is empty
     *
     * @return true if priority queue is empty
     */
    public boolean isEmpty();

    /**
     * remove from ax-priority queue and return the element with largest priority
     *
     * @return the element with largest priority or null if queue is empty
     */
    public T removeMax();

    /**
     * Retrieves, but does not remove, the the element with largest priority of this
     * queue
     *
     * @return the element with biggest priority, or null if this queue is empty
     */
    public T max();

    /**
     * Returns the number of elements in this queue
     *
     * @return the number of elements in this queue
     */
    public int size();


}

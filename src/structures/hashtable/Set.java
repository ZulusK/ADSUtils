package structures.hashtable;

public interface Set<T> {

	/**
	 * Adds the specified element to this hashtable if it is not already present. If
	 * this hashtable already contains the element, the call leaves the hashtable unchanged
	 * and returns false
	 * 
	 * @param e
	 *            figure to be added to this hashtable
	 * @return true if this hashtable did not already contain the specified element
	 */
	boolean add(T e);

	/**
	 * Returns true if this hashtable contains the specified element
	 * 
	 * @param e
	 *            element whose presence in this hashtable is to be tested
	 * @return true if this hashtable contains the specified element e or e == null
	 */
	boolean contains(T e);

	/**
	 * Returns true if this hashtable contains no elements.
	 * 
	 * @return if this hashtable contains no elements
	 */
	boolean isEmpty();

	/**
	 * Removes the specified element from this hashtable if it is present
	 * 
	 * @param e
	 *            element to be removed from this hashtable, if present
	 * @return if this hashtable contained the specified element
	 */
	boolean remove(T e);

	/**
	 * Output the content of hashtable
	 */
	void print();

	/**
	 * Returns the size of hashtable
	 * 
	 * @return the number of elements in the hashtable
	 */
	int size();

}

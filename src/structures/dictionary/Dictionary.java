package structures.dictionary;


public interface Dictionary<K extends Comparable, V> {
    public static final int PREORDER = 1;
    public static final int POSTORDER = 2;
    public static final int INORDER = 3;
    public static final int LEVELORDER = 4;

    /**
     * @param key
     * @return true if this Dictionary contains a mapping for the
     * specified cardNumber
     */
    boolean contains(K key);

    /**
     * @return the number of key-value mappings in this Dictionary
     */
    int size();

    /**
     * Returns true if this dictionary contains no key-value mappings
     *
     * @return true if this dictionary contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * Associates the specified value with the specified cardNumber in this
     * dictionary. If the dictionary previously contained a mapping for the
     * cardNumber, the old value is replaced by the specified value.
     *
     * @param key cardNumber with which the specified value is to be
     *            associated
     * @param e   value to be associated with the specified cardNumber
     * @return the previous value associated with cardNumber, or null if there
     * was no mapping for key
     */
    V put(K key, V e);

    /**
     * Returns the value to which the specified cardNumber is mapped, or null
     * if this dictionary contains no mapping for the cardNumber
     *
     * @param num the cardNumber whose associated value is to be returned
     * @return the value to which the specified num is mapped, or null if this
     * dictionary contains no mapping for the num
     */
    V get(K num);

    /**
     * Removes the mapping for a num from this dictionary if it is present
     *
     * @param key cardNumber whose mapping is to be removed from the dictionary
     * @return previous value associated with cardNumber, or null if there was
     * no mapping for cardNumber
     */
    V remove(K key);

    /**
     * Outputs the dictionary in table form according to given way of traversal
     */
    void printDictionary(int order);

}

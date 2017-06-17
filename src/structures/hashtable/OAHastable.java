package structures.hashtable;

public class OAHastable<T> implements Set<T> {
    private final T DEL = (T) new Object();
    private T[] table;

    /**
     * the number of non-null entries in the hashtable
     */
    private int size;

    /**
     * default size of the hashtable
     */
    private final int initialCapacity = 11;

    /**
     * The load factor is a measure of how full the hash table is allowed to get
     * / before its capacity is automatically increased
     */
    private double loadFactor = 0.75;

    /**
     * It is used in multiplication hash function
     */
    private final double A = (Math.sqrt(5) - 1) / 2;


    public OAHastable() {
        this.table = (T[]) new Object[initialCapacity];
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and
     * default load factor (0.75).
     *
     * @param initialCapacity the initial capacity of the hashtable
     */
    public OAHastable(int initialCapacity) {
        this.table = (T[]) new Object[initialCapacity];
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and
     * the specified load factor.
     *
     * @param initialCapacity the initial capacity of the hashtable
     * @param loadFactor      the load factor of the hashtable
     */
    public OAHastable(int initialCapacity, double loadFactor) {
        this(initialCapacity);
        this.loadFactor = loadFactor;
    }

    /**
     * Returns the number of entries in the hashtable
     *
     * @return the number of entries in the hashtable
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Increases the capacity of and internally reorganizes this hashtable, in
     * order to accommodate and access its entries more efficiently. This method
     * is called when the number of elements in the hashtable exceeds this
     * hashtable's capacity and load factor
     */
    private void rehash() {
        T[] oldTable = this.table;
        this.table = (T[]) new Object[oldTable.length + 16];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && oldTable[i] != DEL) {
                insert(oldTable[i]);
            }
        }
    }

    double frank(double val) {
        return val - (int) val;
    }

    /**
     * The hash function is used to calculate the hasvalue of the object e.
     * Choose hashing method from your variant (table 1): deletion or
     * multiplication
     *
     * @param e some element
     * @return hash value - index in table
     */
    private int hash1(T e) {
        int hash = (int) (frank(e.hashCode() * A) * table.length);
        return hash;
    }

    private int hash2(T e) {
        int hash = e.hashCode() % table.length;
        return hash;
    }

    private final int c1 = 7;
    private final int c2 = 5;

    private int hash(T e, int probe) {
        //linear probing
//        int hash = (e.hashCode() + probe) % table.length;
        //quadratic probing
//        int hash = (e.hashCode() + c1 * probe + c2 * probe * probe) % table.length;
        //double probing
        int hash = Math.abs(hash1(e) + probe * hash2(e)) % table.length;
        return hash;
    }

    private boolean insert(T e) {
        int probe = 0;
        int index = 0;
        do {
            index = hash(e, probe);
            probe++;
            if (table[index] == null || table[index] == DEL) {
                table[index] = e;
                return true;
            }
        } while (probe != table.length && !table[index].equals(e));
        return false;
    }

    @Override
    public boolean add(T e) {
        if (e == null) return false;
        if (size / (float) table.length >= loadFactor) {
            rehash();
        }
        if (insert(e)) {
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(T e) {
        if (e == null) return false;
        int probe = 0;
        int index = 0;
        do {
            index = hash(e, probe);
            probe++;
            if (table[index] == null) {
                break;
            } else if (table[index].equals(e)) {
                return true;
            }
        } while (probe != table.length);
        return false;
    }

    @Override
    public boolean remove(T e) {
        if (e == null) {
            return false;
        }
        int probe = 0;
        int index = 0;
        do {
            index = hash(e, probe);
            probe++;
            if (table[index] == null) {
                break;
            } else if (table[index].equals(e)) {
                table[index] = DEL;
                size--;
                return true;
            }
        } while (probe != table.length);
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        System.out.println("Hashtable: size " + size);
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.printf("[%d]slot is empty\n", i);
            } else {
                System.out.printf("[%d]%s\n", i, table[i]);
            }
        }
    }

}



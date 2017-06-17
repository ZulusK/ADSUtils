package structures.hashtable;

public class SChHastable<T> implements Set<T> {

    private DLNode<T>[] table;

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

    /**
     * Constructs a new, empty hashtable with a default initial capacity (11)
     * and load factor (0.75).
     */
    public SChHastable() {
        this.table = new DLNode[initialCapacity];
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and
     * default load factor (0.75).
     *
     * @param initialCapacity the initial capacity of the hashtable
     */
    public SChHastable(int initialCapacity) {
        this.table = new DLNode[initialCapacity];
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and
     * the specified load factor.
     *
     * @param initialCapacity the initial capacity of the hashtable
     * @param loadFactor      the load factor of the hashtable
     */
    public SChHastable(int initialCapacity, double loadFactor) {
        this(initialCapacity);
        this.loadFactor = loadFactor;
    }

    /**
     * Returns the number of entries in the hashtable
     *
     * @return the number of entries in the hashtable
     */
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
        DLNode<T>[] oldTable = this.table;
        this.table = new DLNode[oldTable.length + 16];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                DLNode<T> curr = oldTable[i];
                while (curr != null) {
                    insert(curr.data);
                    curr = curr.next;
                }
            }
        }
    }

    double frank(double val) {
        return val - (int) val;
    }

    private int hash(T e) {
        int hash = (int) (frank(e.hashCode() * A) * table.length);
        return 0;
    }

    private void insert(T e) {
        int ind = hash(e);
        DLNode<T> newNode = new DLNode<>();
        newNode.data = e;
        newNode.next = table[ind];
        if (table[ind] != null) {
            table[ind].prev = newNode;
        }
        table[ind] = newNode;
    }

    @Override
    public boolean add(T e) {
        if (e == null || contains(e)) return false;
        if (size / (float) table.length >= loadFactor) {
            rehash();
        }
        insert(e);
        size++;
        return true;
    }

    @Override
    public boolean contains(T e) {
        if (e == null) {
            return false;
        } else {
            int index = hash(e);
            if (table[index] != null) {
                for (DLNode<T> curr = table[index]; curr != null; curr = curr.next) {
                    if (curr.data.equals(e)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    @Override
    public boolean remove(T e) {
        if (e == null) {
            return false;
        }
        int ind = hash(e);
        //search for item
        for (DLNode<T> curr = table[ind]; curr != null; curr = curr.next) {
            if (curr.data.equals(e)) {
                //remove node
                if (curr.next != null)
                    curr.next.prev = curr.prev;
                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                } else {
                    table[ind] = curr.next;
                }
                curr.next = null;
                curr.prev = null;
                curr.data = null;
                size--;
                return true;
            }
        }
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
                System.out.printf("[%d]", i, table[i]);
                for (DLNode<T> curr = table[i]; curr != null; curr = curr.next) {
                    System.out.print(curr.data + ", ");
                }
                System.out.println();
            }
        }

    }

    class DLNode<T> {
        private T data;
        private DLNode next;
        private DLNode prev;
    }
}



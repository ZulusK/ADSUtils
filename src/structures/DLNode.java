package structures;

public class DLNode<T> {
    T data; // the data stored in this node.

    DLNode next; // pointer to the next node
    DLNode prev; // pointer to the previous nod

    /**
     * Construct the node of doubly-linked list with null pointers to the next
     * and previous nodes
     *
     * @param data the data to stored in this node
     */
    public DLNode(T data) {
        this.data = data;
        next = null;
        prev = null;
    }

    /**
     * Construct the node of doubly-linked list and fill its fields
     *
     * @param data the data to stored in this node
     * @param next pointer to the next node
     * @param prev pointer to the previous node
     */
    public DLNode(T data, DLNode next, DLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DLNode<T> getNext() {
        return next;
    }

    public void setNext(DLNode<T> next) {
        this.next = next;
    }

    public DLNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DLNode<T> prev) {
        this.prev = prev;
    }

}

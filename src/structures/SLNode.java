package structures;


public class SLNode<T> {
	SLNode next; // pointer to the next node

	T data; // the data stored in this node.

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SLNode<T> getNext() {
		return next;
	}

	public void setNext(SLNode<T> next) {
		this.next = next;
	}


	public SLNode(T data) {
		this.data = data;
		next = null;
	}


	public SLNode(T data, SLNode next) {
		this.data = data;
		this.next = next;
	}
}

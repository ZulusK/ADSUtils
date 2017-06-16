package stuctures;

/**
 * Created by Zulus on 14.01.2017.
 */
public class SLNode {
    private int data;
    private SLNode next;

    public SLNode(int data) {
        this.data = data;
        this.next = null;
    }

    public static SLNode addFirst(SLNode head, int data) {
        SLNode node = new SLNode(data);
        node.next = head;
        return node;
    }

    public static SLNode getTail(SLNode head) {
        if (head != null)
            while (head.next != null) {
                head = head.next;
            }
        return head;
    }

    public static SLNode addLast(SLNode head, int data) {
        if (head != null) {
            head = getTail(head);
        }
        return addAfter(head, data);
    }

    public static SLNode removeFirst(SLNode head) {
        if (head != null) return head.next;
        else return null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    public int getData() {

        return data;
    }

    public SLNode getNext() {
        return next;
    }

    public static SLNode removeAfter(SLNode node) {
        if (node != null) {
            SLNode rmNode=node.next;
            if(rmNode!=null){
                node.next=rmNode.next;
                rmNode.next=null;
            }else{
                node.next=null;
            }
            return rmNode;
        } else return null;
    }
    public static SLNode removeLast(SLNode head){
        if(head==null) return null;
        else if(head.next==null) return head;
        else{
            while(head.next.next!=null){
                head=head.next;
            }
            return removeAfter(head);
        }

    }

    public static SLNode addAfter(SLNode node, int data) {
        SLNode newNode = new SLNode(data);
        if (node != null) {
            node.next = newNode;
        }
        return newNode;
    }

    public void print() {
        System.out.printf("%d ", data);
    }

    public static void printList(SLNode head) {
        System.out.print("List's size=" + getSize(head) + " : ");
        while (head != null) {
            head.print();
            head = head.next;
        }
        System.out.println();
    }

    public static int getSize(SLNode head) {
        if (head == null) return 0;
        else {
            int count = 0;
            while (head != null) {
                head = head.next;
                count++;
            }
            return count;
        }
    }

}

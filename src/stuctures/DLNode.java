package stuctures;

/**
 * Created by Zulus on 14.01.2017.
 */
public class DLNode {
    public DLNode prev;
    public DLNode next;
    public int data;

    public DLNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public static void print(DLNode node) {
        System.out.printf("%d ", node.data);
    }

    public static void printList(DLNode head) {
        System.out.print("DLList size=" + size(head) + ": ");
        while (head != null) {
            print(head);
            head = head.next;
        }
        System.out.println();
    }

    public static int size(DLNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public static DLNode addFirst(DLNode head, int data) {
        DLNode newNode = new DLNode(data);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        return newNode;
    }

    public static DLNode addLast(DLNode head, int data) {
        if (head == null) {
            head = addFirst(head, data);
        } else {
            DLNode newNode = new DLNode(data);
            DLNode tail = getTail(head);
            tail.next = newNode;
            newNode.prev = tail;
        }
        return head;
    }

    public static DLNode getTail(DLNode head) {
        if (head == null) return null;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void addAfter(DLNode x, DLNode y) {
        if (y != null) {
            x.prev = y;
            x.next = y.next;
            if (y.next != null) {
                y.next.prev = x;
            }
            y.next = x;
        }
    }
    public static DLNode addBefore(DLNode y, int data,DLNode head) {
        DLNode x=new DLNode(data);
        if (y != null) {
            x.next = y;
            x.prev = y.prev;
            if (y.prev != null) {
                y.prev.next = x;
            }else{
                head=x;
            }
            y.prev = x;
        }else head=x;
        return head;
    }

    public static DLNode remove(DLNode head, DLNode rmNode) {
        if (rmNode.prev != null) {
            rmNode.prev.next = rmNode.next;
        } else {
            head = head.next;
        }
        if (rmNode.next != null) {
            rmNode.next.prev = rmNode.prev;
        }
        rmNode.next = null;
        rmNode.prev = null;

        return head;
    }

    public static DLNode removeFirst(DLNode head) {
        return remove(head, head);
    }

    public static DLNode removeLast(DLNode head) {
        return remove(head,getTail(head));
    }
    public void clearLinks(){
        this.next=null;
        this.prev=null;
    }
}

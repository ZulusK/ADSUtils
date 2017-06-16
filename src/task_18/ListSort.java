package task_18;

import task_17.DLNode;

/**
 * Created by Zulus on 15.01.2017.
 */
public class ListSort {
    public static DLNode getMax(DLNode head) {
        DLNode max = head;
        if (head != null) {
            while (head != null) {
                if (head.data > max.data) {
                    max = head;
                }
                head = head.next;
            }
        }
        return max;
    }

    public static DLNode selectionSort(DLNode head) {
        if (head == null) return null;
        else {
            DLNode sortedHead = null;
            DLNode maxNode = null;
            while ((maxNode = getMax(head)) != null) {
                head = DLNode.remove(head, maxNode);
                sortedHead = DLNode.addLast(sortedHead, maxNode.data);
            }
            return sortedHead;
        }
    }

    public static DLNode insertToSortedList(DLNode head, DLNode newNode) {
        DLNode tmpNode = head;
        if (tmpNode == null) return newNode;
        while (tmpNode.next != null && tmpNode.data > newNode.data) {
            tmpNode = tmpNode.next;
        }
        head = DLNode.addBefore(tmpNode, newNode.data, head);
        return head;
    }

    public static DLNode insetrtionSort(DLNode head) {
        DLNode s = null;
        while (head != null) {
            DLNode insertNode = head;
            head = head.next;
            insertNode.clearLinks();
            s = insertToSortedList(s, insertNode);
        }
        return s;
    }
}

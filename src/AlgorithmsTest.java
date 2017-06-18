import algorithms.ArrayOperations;
import algorithms.ArraySort;
import org.junit.Test;
import structures.deque.ArrayDeque;
import structures.deque.LinkedDeque;
import structures.dictionary.BSTree;
import structures.hashtable.OAHastable;
import structures.hashtable.SChHastable;
import structures.heap.max_priority_queue.*;
import structures.list.ArrayList;
import structures.list.DoublyLinkedList;
import structures.list.SinglyLinkedList;
import structures.queue.ArrayQueue;
import structures.queue.LinkedQueue;
import structures.stack.ArrayStack;
import structures.stack.LinkedStack;

import static junit.framework.Assert.*;

/**
 * Created by Danil Kazimirov on 6/15/2017.
 */
public class AlgorithmsTest {
    @Test
    public void testInsertionSort_Sedj() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.insertionSortSedj(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testInsertionSort_MTI() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.insertionSortMTI(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testBubleSort() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.bubleSort(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testBubleSort_double() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.doubleBubleSort(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testBitRadixSort() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.bitRadixSort(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testBucketSort() {
        int[] arr = ArrayOperations.getRandomizeArray(30, 0, 30);
        ArraySort.bucketSort(arr);
//        assertTrue(ArrayOperations.isSorted(arr,false)||ArrayOperations.isSorted(arr,true));
    }

    @Test
    public void testCountingSort() {
        int[] arr = ArrayOperations.getRandomizeArray(30, 0, 30);
        ArraySort.countingSort(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testCountingStableSort() {
        int[] arr = ArrayOperations.getRandomizeArray(30, 0, 30);
        arr = ArraySort.countingSortStable(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testSelectionSort() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.selectionSort(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testShellSort_Knut() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.shellSortKnut(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testShellSort_Sej() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.shellSortSej(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testMergesort2() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.mergesortTD(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testMergesortBD() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.mergesortBD(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testQuicksortL() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.quicksortL(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testQuickR() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.quicksortR(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testQuickM() {
        int[] arr = ArrayOperations.getRandomizeArray(30, -30, 30);
        ArraySort.quicksortM(arr);
        assertTrue(ArrayOperations.isSorted(arr, false) || ArrayOperations.isSorted(arr, true));
    }

    @Test
    public void testArrayList_add() {
        ArrayList<Integer> list = new ArrayList<>(1);
        assertTrue(list.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(list.add(i));
        }
        assertEquals(list.size(), N);
    }

    @Test
    public void testArrayList_add_index() {
        ArrayList<Integer> list = new ArrayList<>(1);
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(list.add(i / 2, i));
        }
        assertEquals(list.size(), N);
    }

    @Test
    public void testArrayList_get() {
        ArrayList<Integer> list = new ArrayList<>(10);
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(list.get(i).intValue(), i);
        }
    }

    @Test
    public void testArrayList_remove() {
        ArrayList<Integer> list = new ArrayList<>(10);
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //remove last
        assertEquals(list.remove(N - 1).intValue(), N - 1);
        assertEquals(list.size(), N - 1);
        //remove first
        assertEquals(list.remove(0).intValue(), 0);
        assertEquals(list.size(), N - 2);
        //remove middle
        assertEquals(list.get(N / 2), list.remove(N / 2));
        assertEquals(list.size(), N - 3);
        //clear list
        for (int i = list.size(); i > 0; i--) {
            assertFalse(list.remove(0) == null);
        }
        assertTrue(list.isEmpty());
        //try to remove from empty list
        assertEquals(list.remove(0), null);
    }

    @Test
    public void testArrayList_removeByVal() {
        ArrayList<String> list = new ArrayList<>(10);
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(String.valueOf(i));
        }
        //remove last
        String key = String.valueOf(N - 1);
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 1);
        //remove first
        key = "0";
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 2);
        //remove middle
        key = String.valueOf(N / 2);
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 3);
        //clear list
        for (int i = list.size(); i > 0; i--) {
            list.remove(0);
        }
        assertTrue(list.isEmpty());
        //try to remove from empty list
        assertFalse(list.remove("2"));
    }

    @Test
    public void testArrayList_set() {
        ArrayList<Integer> list = new ArrayList<>(10);
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //hashtable first
        assertEquals(list.set(0, -1).intValue(), 0);
        //hashtable last
        assertEquals(list.set(N - 1, -1).intValue(), N - 1);
        //hashtable out of bounds
        assertEquals(list.set(30, 12), null);
    }

    @Test
    public void testDoublyLinkedList_add() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(list.add(i));
        }
        assertEquals(list.size(), N);
    }

    @Test
    public void testDoublyLinkedList_add_index() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(list.add(i / 2, i));
        }
        assertEquals(list.size(), N);
    }

    @Test
    public void testDoublyLinkedList_get() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(list.get(i).intValue(), i);
        }
    }

    @Test
    public void testDoublyLinkedList_remove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //remove last
        assertEquals(list.remove(N - 1).intValue(), N - 1);
        assertEquals(list.size(), N - 1);
        //remove first
        assertEquals(list.remove(0).intValue(), 0);
        assertEquals(list.size(), N - 2);
        //remove middle
        assertEquals(list.get(N / 2), list.remove(N / 2));
        assertEquals(list.size(), N - 3);
        //clear list
        for (int i = list.size(); i > 0; i--) {
            assertFalse(list.remove(0) == null);
        }
        assertTrue(list.isEmpty());
        //try to remove from empty list
        assertEquals(list.remove(0), null);
    }

    @Test
    public void testDoublyLinkedList_removeByVal() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(String.valueOf(i));
        }
        //remove last
        String key = String.valueOf(N - 1);
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 1);
        //remove first
        key = "0";
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 2);
        //remove middle
        key = String.valueOf(N / 2);
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 3);
        //clear list
        for (int i = list.size(); i > 0; i--) {
            list.remove(0);
        }
        assertTrue(list.isEmpty());
        //try to remove from empty list
        assertFalse(list.remove("2"));
    }

    @Test
    public void testDoublyLinkedList_set() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //hashtable first
        assertEquals(list.set(0, -1).intValue(), 0);
        //hashtable last
        assertEquals(list.set(N - 1, -1).intValue(), N - 1);
        //hashtable out of bounds
        assertEquals(list.set(30, 12), null);
    }

    @Test
    public void testSinglyLinkedList_add() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(list.add(i));
        }
        assertEquals(list.size(), N);
    }

    @Test
    public void testSinglyLinkedList_add_index() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(list.add(i / 2, i));
        }
        assertEquals(list.size(), N);
    }

    @Test
    public void testSinglyLinkedList_get() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(list.get(i).intValue(), i);
        }
    }

    @Test
    public void testSinglyLinkedList_remove() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //remove last
        assertEquals(list.remove(N - 1).intValue(), N - 1);
        assertEquals(list.size(), N - 1);
        //remove first
        assertEquals(list.remove(0).intValue(), 0);
        assertEquals(list.size(), N - 2);
        //remove middle
        assertEquals(list.get(N / 2), list.remove(N / 2));
        assertEquals(list.size(), N - 3);
        //clear list
        for (int i = list.size(); i > 0; i--) {
            assertFalse(list.remove(0) == null);
        }
        assertTrue(list.isEmpty());
        //try to remove from empty list
        assertEquals(list.remove(0), null);
    }

    @Test
    public void testSinglyLinkedList_removeByVal() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(String.valueOf(i));
        }
        //remove last
        String key = String.valueOf(N - 1);
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 1);
        //remove first
        key = "0";
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 2);
        //remove middle
        key = String.valueOf(N / 2);
        assertTrue(list.remove(key));
        assertEquals(list.size(), N - 3);
        //clear list
        for (int i = list.size(); i > 0; i--) {
            list.remove(0);
        }
        assertTrue(list.isEmpty());
        //try to remove from empty list
        assertFalse(list.remove("2"));
    }

    @Test
    public void testSinglyLinkedList_set() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //hashtable first
        assertEquals(list.set(0, -1).intValue(), 0);
        //hashtable last
        assertEquals(list.set(N - 1, -1).intValue(), N - 1);
        //hashtable out of bounds
        assertEquals(list.set(30, 12), null);
    }

    @Test
    public void testArrayQueue_eq() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(1);
        assertTrue(queue.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(queue.enqueue(i));
        }
        assertEquals(queue.size(), N);
    }

    @Test
    public void testArrayQueue_head() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        assertEquals(queue.head(), null);
        queue.enqueue(0);
        assertEquals(queue.head().intValue(), 0);
        queue.enqueue(1);
        assertEquals(queue.head().intValue(), 0);
    }

    @Test
    public void testArrayQueue_deq() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        int N = 10;
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(queue.head().intValue(), i);
            assertEquals(queue.dequeue().intValue(), i);
        }
        assertTrue(queue.isEmpty());
        assertEquals(queue.dequeue(), null);
    }

    @Test
    public void testArrayQueue_deq_eq() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < N / 2; i++) {
            queue.dequeue();
        }
        for (int i = 0; i < N; i++) {
            assertTrue(queue.enqueue(-i));
        }
        for (int i = 0; i < N / 2; i++) {
            queue.dequeue();
        }
        assertEquals(queue.size(), N);
        assertEquals(queue.head().intValue(), 0);
    }

    @Test
    public void testLinkedQueue_eq() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(queue.enqueue(i));
        }
        assertEquals(queue.size(), N);
    }

    @Test
    public void testLinkedQueue_head() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        assertEquals(queue.head(), null);
        queue.enqueue(0);
        assertEquals(queue.head().intValue(), 0);
        queue.enqueue(1);
        assertEquals(queue.head().intValue(), 0);
    }

    @Test
    public void testLinkedQueue_deq() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(queue.head().intValue(), i);
            assertEquals(queue.dequeue().intValue(), i);
        }
        assertTrue(queue.isEmpty());
        assertEquals(queue.dequeue(), null);
    }


    @Test
    public void testLinkedQueue_deq_eq() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < N / 2; i++) {
            queue.dequeue();
        }
        for (int i = 0; i < N; i++) {
            assertTrue(queue.enqueue(-i));
        }
        for (int i = 0; i < N / 2; i++) {
            queue.dequeue();
        }
        assertEquals(queue.size(), N);
        assertEquals(queue.head().intValue(), 0);
    }

    @Test
    public void testArrayStack_push() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        assertEquals(stack.size(), N);
    }

    @Test
    public void testArrayStack_pop() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(stack.pop().intValue(), N - 1 - i);
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testArrayStack_top() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(stack.top().intValue(), N - 1 - i);
            stack.pop().intValue();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testArrayStack_push_pop() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N / 2; i++) {
            stack.pop();
        }
        for (int i = 0; i < N; i++) {
            stack.push(-i);
        }
        assertEquals(stack.size(), N + N / 2);
        for (int i = 0; i < N / 2; i++) {
            stack.pop();
        }
        assertEquals(stack.size(), N);
        assertEquals(stack.top().intValue(), -4);
    }

    @Test
    public void testLinkedStack_push() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        assertEquals(stack.size(), N);
    }

    @Test
    public void testLinkedStack_pop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(stack.pop().intValue(), N - 1 - i);
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testLinkedStack_top() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(stack.top().intValue(), N - i - 1);
            stack.pop().intValue();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testLinkedStack_push_pop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N / 2; i++) {
            stack.pop();
        }
        for (int i = 0; i < N; i++) {
            stack.push(-i);
        }
        assertEquals(stack.size(), N + N / 2);
        for (int i = 0; i < N / 2; i++) {
            stack.pop();
        }
        assertEquals(stack.size(), N);
        assertEquals(stack.top().intValue(), -4);
    }

    @Test
    public void testArrayDeque_addFirst() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int N = 10;
        assertTrue(deq.isEmpty());
        for (int i = 0; i < N; i++) {
            assertTrue(deq.addFirst(i));
        }
        assertEquals(deq.size(), N);
    }

    @Test
    public void testArrayDeque_addLast() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(deq.addLast(i));
        }
        assertEquals(deq.size(), N);
    }

    @Test
    public void testArrayDeque_add() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(deq.addLast(i));
            assertTrue(deq.addFirst(-i));
        }
        assertEquals(deq.size(), N * 2);
    }

    @Test
    public void testArrayDeque_get() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(-i);
            deq.addLast(i);
        }
        assertEquals(deq.getFirst().intValue(), -(N - 1));
        assertEquals(deq.getLast().intValue(), N - 1);
    }

    @Test
    public void testArrayDeque_removeFirst() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(deq.removeFirst().intValue(), N - 1 - i);
        }
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testArrayDeque_removeLast() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(deq.removeLast().intValue(), i);
        }
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testArrayDeque_remove() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(i);
        }
        for (int i = 0; i < N / 2; i++) {
            assertEquals(deq.removeLast().intValue(), i);
            assertEquals(deq.removeFirst().intValue(), N - 1 - i);
        }
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testArrayDeque_remove_add() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);
        assertEquals(deq.removeFirst().intValue(), 3);
        assertEquals(deq.removeLast().intValue(), 1);
        deq.addLast(4);
        assertEquals(deq.getLast().intValue(), 4);
        deq.addFirst(-1);
        assertEquals(deq.getFirst().intValue(), -1);
    }

    @Test
    public void testLinkedDeque_addFirst() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        int N = 10;
        assertTrue(deq.isEmpty());
        for (int i = 0; i < N; i++) {
            assertTrue(deq.addFirst(i));
        }
        assertEquals(deq.size(), N);
    }

    @Test
    public void testLinkedDeque_addLast() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(deq.addLast(i));
        }
        assertEquals(deq.size(), N);
    }

    @Test
    public void testLinkedDeque_add() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            assertTrue(deq.addLast(i));
            assertTrue(deq.addFirst(-i));
        }
        assertEquals(deq.size(), N * 2);
    }

    @Test
    public void testLinkedDeque_get() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(-i);
            deq.addLast(i);
        }
        assertEquals(deq.getFirst().intValue(), -(N - 1));
        assertEquals(deq.getLast().intValue(), N - 1);
    }

    @Test
    public void testLinkedDeque_removeFirst() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(deq.removeFirst().intValue(), N - 1 - i);
        }
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testLinkedDeque_removeLast() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(i);
        }
        for (int i = 0; i < N; i++) {
            assertEquals(deq.removeLast().intValue(), i);
        }
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testLinkedDeque_remove() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            deq.addFirst(i);
        }
        for (int i = 0; i < N / 2; i++) {
            assertEquals(deq.removeLast().intValue(), i);
            assertEquals(deq.removeFirst().intValue(), N - 1 - i);
        }
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testLinkedDeque_remove_add() {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);
        assertEquals(deq.removeFirst().intValue(), 3);
        assertEquals(deq.removeLast().intValue(), 1);
        deq.addLast(4);
        assertEquals(deq.getLast().intValue(), 4);
        deq.addFirst(-1);
        assertEquals(deq.getFirst().intValue(), -1);
    }

    @Test
    public void testOAHastable_add() {
        OAHastable<Integer> table = new OAHastable<>();
        assertTrue(table.isEmpty());
        int N = 17;
        for (int i = 0; i < N; i++) {
            assertTrue(table.add(i));
        }
        for (int i = 0; i < N; i++) {
            assertFalse(table.add(i));
        }
        assertEquals(table.size(), N);
    }

    @Test
    public void testOAHastable_contains() {
        OAHastable<Integer> table = new OAHastable<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            table.add(i);
        }
        assertTrue(table.contains(0));
        assertFalse(table.contains(N));
        assertFalse(table.contains(-1));
    }

    @Test
    public void testOAHastable_remove() {
        OAHastable<Integer> table = new OAHastable<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            table.add(i);
        }
        assertTrue(table.remove(0));
        assertTrue(table.remove(9));
        assertTrue(table.remove(5));
        assertFalse(table.remove(-1));
        assertFalse(table.remove(N));
        assertEquals(table.size(), N - 3);
    }

    @Test
    public void testOAHastable_remove_add() {
        OAHastable<Integer> table = new OAHastable<>();
        table.add(0);
        assertTrue(table.remove(0));
        assertTrue(table.add(0));

        table.add(1);
        table.add(2);
        table.add(3);

        assertTrue(table.remove(2));
        assertTrue(table.remove(3));
        assertTrue(table.remove(1));
        assertFalse(table.remove(-1));
        assertEquals(table.size(), 1);
    }

    @Test
    public void testSChHastable_add() {
        SChHastable<Integer> table = new SChHastable<>();
        assertTrue(table.isEmpty());
        int N = 17;
        for (int i = 0; i < N; i++) {
            assertTrue(table.add(i));
        }
        for (int i = 0; i < N; i++) {
            assertFalse(table.add(i));
        }
        assertEquals(table.size(), N);
    }

    @Test
    public void testSChHastable_contains() {
        SChHastable<Integer> table = new SChHastable<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            table.add(i);
        }
        assertTrue(table.contains(0));
        assertFalse(table.contains(N));
        assertFalse(table.contains(-1));
    }

    @Test
    public void testSChHastable_remove() {
        SChHastable<Integer> table = new SChHastable<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            table.add(i);
        }
        assertTrue(table.remove(0));
        assertTrue(table.remove(9));
        assertTrue(table.remove(5));
        assertFalse(table.remove(-1));
        assertFalse(table.remove(N));
        assertEquals(table.size(), N - 3);
    }

    @Test
    public void testSChHastable_remove_add() {
        SChHastable<Integer> table = new SChHastable<>();
        table.add(0);
        assertTrue(table.remove(0));
        assertTrue(table.add(0));

        table.add(1);
        table.add(2);
        table.add(3);

        assertTrue(table.remove(2));
        assertTrue(table.remove(3));
        assertTrue(table.remove(1));
        assertFalse(table.remove(-1));
        assertEquals(table.size(), 1);
    }

    @Test
    public void testBStree_add_uniq() {
        BSTree<Integer, String> tree = new BSTree<>();
        assertTrue(tree.isEmpty());
        int values[] = {5, 4, -10, 1, 3, 14, 15, 7, 2};
        for (int i = 0; i < values.length; i++) {
            assertEquals(tree.put(i, values[i] + ""), null);
        }
        assertEquals(tree.size(), values.length);
    }

    @Test
    public void testBStree_add_not_uniq() {
        BSTree<Integer, String> tree = new BSTree<>();
        assertTrue(tree.isEmpty());
        int values[] = {5, 4, -10, 1, 3, 14, 15, 7, 2};
        for (int i = 0; i < values.length; i++) {
            tree.put(i, values[i] + "");
        }
        for (int i = 0; i < values.length; i++) {
            assertEquals(tree.put(i, i + ""), values[i] + "");
            assertEquals(tree.put(i, ""), i + "");
        }
        assertEquals(tree.size(), values.length);
    }

    @Test
    public void testBStree_contains() {
        BSTree<Integer, String> tree = new BSTree<>();
        assertTrue(tree.isEmpty());
        int values[] = {5, 4, -10, 1, 3, 14, 15, 7, 2};
        for (int i = 0; i < values.length; i++) {
            tree.put(i, values[i] + "");
        }
        for (int i = 0; i < values.length; i++) {
            assertTrue(tree.contains(i));
        }
        assertFalse(tree.contains(-1));
        assertFalse(tree.contains(100));
    }

    @Test
    public void testBStree_get() {
        BSTree<Integer, String> tree = new BSTree<>();
        assertTrue(tree.isEmpty());
        int values[] = {5, 4, -10, 1, 3, 14, 15, 7, 2};
        for (int i = 0; i < values.length; i++) {
            tree.put(i, values[i] + "");
        }
        for (int i = 0; i < values.length; i++) {
            assertEquals(tree.get(i), values[i] + "");
        }
        assertEquals(tree.get(-1), null);
        assertEquals(tree.get(100), null);
        assertEquals(tree.size(), values.length);
    }

    @Test
    public void testBStree_remove() {
        BSTree<Integer, String> tree = new BSTree<>();
        assertTrue(tree.isEmpty());
        int values[] = {5, 4, -10, 1, 3, 14, 15, 7, 2};
        for (int i = 0; i < values.length; i++) {
            tree.put(i, values[i] + "");
        }
        for (int i = 0; i < values.length; i++) {
            assertEquals(tree.remove(i), values[i] + "");
        }
        assertTrue(tree.isEmpty());
        for (int i = 0; i < values.length; i++) {
            assertEquals(tree.get(i), null);
        }
        assertEquals(tree.get(-1), null);
        assertEquals(tree.size(), 0);
    }

    @Test
    public void testBStree_remove_add() {
        BSTree<Integer, String> tree = new BSTree<>();
        assertTrue(tree.isEmpty());
        int values[] = {5, 4, -10, 1, 3, 14, 15, 7, 2};
        for (int i = 0; i < values.length; i++) {
            tree.put(i, values[i] + "");
        }
        for (int i = 0; i < values.length; i++) {
            tree.remove(i);
        }
        assertEquals(tree.size(), 0);
        for (int i = 0; i < values.length; i++) {
            assertEquals(tree.put(i, values[i] + ""), null);
        }
        assertEquals(tree.size(), values.length);
        for (int i = 0; i < values.length; i++) {
            assertEquals(tree.get(i), values[i] + "");
        }
    }

    @Test
    public void testSPArrayQueue_add() {
        SortedArrayPriorityQueue<Integer> queue = new SortedArrayPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        assertTrue(queue.isEmpty());
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), values.length);
    }

    @Test
    public void testSPArrayQueue_remove() {
        SortedArrayPriorityQueue<Integer> queue = new SortedArrayPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.removeMax().intValue(), values[i]);
        }
        assertTrue(queue.isEmpty());
        assertEquals(queue.removeMax(), null);
    }

    @Test
    public void testSPArrayQueue_get() {
        SortedArrayPriorityQueue<Integer> queue = new SortedArrayPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.max().intValue(), values[i]);
            queue.removeMax();
        }
    }

    @Test
    public void testSPArrayQueue_remove_add() {
        SortedArrayPriorityQueue<Integer> queue = new SortedArrayPriorityQueue<>();
        queue.insert(1);
        queue.insert(-2);
        queue.insert(5);
        queue.removeMax();
        queue.insert(6);
        assertEquals(queue.size(), 3);
        assertEquals(queue.max().intValue(), 6);
    }

    @Test
    public void testSPListQueue_add() {
        SortedListPriorityQueue<Integer> queue = new SortedListPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        assertTrue(queue.isEmpty());
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), values.length);
    }

    @Test
    public void testSPListQueue_remove() {
        SortedListPriorityQueue<Integer> queue = new SortedListPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.removeMax().intValue(), values[i]);
        }
        assertTrue(queue.isEmpty());
        assertEquals(queue.removeMax(), null);
    }

    @Test
    public void testSPListQueue_get() {
        SortedListPriorityQueue<Integer> queue = new SortedListPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.max().intValue(), values[i]);
            queue.removeMax();
        }
    }

    @Test
    public void testSPListQueue_remove_add() {
        SortedListPriorityQueue<Integer> queue = new SortedListPriorityQueue<>();
        queue.insert(1);
        queue.insert(-2);
        queue.insert(5);
        queue.removeMax();
        queue.insert(6);
        assertEquals(queue.size(), 3);
        assertEquals(queue.max().intValue(), 6);
    }

    @Test
    public void testUSPArrayQueue_add() {
        UnsortedArrayPriorityQueue<Integer> queue = new UnsortedArrayPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        assertTrue(queue.isEmpty());
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), values.length);
    }

    @Test
    public void testUSPArrayQueue_remove() {
        UnsortedArrayPriorityQueue<Integer> queue = new UnsortedArrayPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.removeMax().intValue(), values[i]);
        }
        assertTrue(queue.isEmpty());
        assertEquals(queue.removeMax(), null);
    }

    @Test
    public void testUSPArrayQueue_get() {
        UnsortedArrayPriorityQueue<Integer> queue = new UnsortedArrayPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.max().intValue(), values[i]);
            queue.removeMax();
        }
    }

    @Test
    public void testUSPArrayQueue_remove_add() {
        UnsortedArrayPriorityQueue<Integer> queue = new UnsortedArrayPriorityQueue<>();
        queue.insert(1);
        queue.insert(-2);
        queue.insert(5);
        queue.removeMax();
        queue.insert(6);
        assertEquals(queue.size(), 3);
        assertEquals(queue.max().intValue(), 6);
    }

    @Test
    public void testUSPListQueue_add() {
        UnsortedListPriorityQueue<Integer> queue = new UnsortedListPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        assertTrue(queue.isEmpty());
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), values.length);
    }

    @Test
    public void testUSPListQueue_remove() {
        UnsortedListPriorityQueue<Integer> queue = new UnsortedListPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.removeMax().intValue(), values[i]);
        }
        assertTrue(queue.isEmpty());
        assertEquals(queue.removeMax(), null);
    }

    @Test
    public void testUSPListQueue_get() {
        UnsortedListPriorityQueue<Integer> queue = new UnsortedListPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.max().intValue(), values[i]);
            queue.removeMax();
        }
    }

    @Test
    public void testUSPListQueue_remove_add() {
        UnsortedListPriorityQueue<Integer> queue = new UnsortedListPriorityQueue<>();
        queue.insert(1);
        queue.insert(-2);
        queue.insert(5);
        queue.removeMax();
        queue.insert(6);
        assertEquals(queue.size(), 3);
        assertEquals(queue.max().intValue(), 6);
    }

    @Test
    public void testHeapQueue_add() {
        HeapPriorityQueue<Integer> queue = new HeapPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        assertTrue(queue.isEmpty());
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), values.length);
    }

    @Test
    public void testHeapQueue_remove() {
        HeapPriorityQueue<Integer> queue = new HeapPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.removeMax().intValue(), values[i]);
        }
        assertTrue(queue.isEmpty());
        assertEquals(queue.removeMax(), null);
    }

    @Test
    public void testHeapQueue_get() {
        HeapPriorityQueue<Integer> queue = new HeapPriorityQueue<>();
        int[] values = {1, 4, -2, 5, 0, 12, 13, -2, 5, 1, 2, -2};
        for (int i = 0; i < values.length; i++) {
            queue.insert(values[i]);
        }
        ArraySort.quicksortL(values);
        values = ArrayOperations.reverse(values);
        for (int i = 0; i < values.length; i++) {
            assertEquals(queue.max().intValue(), values[i]);
            queue.removeMax();
        }
    }

    @Test
    public void testHeapQueue_remove_add() {
        HeapPriorityQueue<Integer> queue = new HeapPriorityQueue<>();
        queue.insert(1);
        queue.insert(-2);
        queue.insert(5);
        queue.removeMax();
        queue.insert(6);
        assertEquals(queue.size(), 3);
        assertEquals(queue.max().intValue(), 6);
    }
}
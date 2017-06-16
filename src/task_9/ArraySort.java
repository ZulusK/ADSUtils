package task_9;

import task_17.DLNode;
import task_18.ListSort;
import task_6.ArrayOperations;

import static task_6.ArrayOperations.swap;

/**
 * Created by Zulus on 13.01.2017.
 */
public class ArraySort {
    public static int[] doubleBubleSort(int[] arr) {
        int l = 0;
        int r = arr.length;
        boolean isSorted = false;
        while (r > l && !isSorted) {
            isSorted = true;
            for (int i = l; i < r - 1; i++) {
                for (int j = i + 1; j < r; j++) {
                    if (arr[i] > arr[j]) {
                        isSorted = false;
                        swap(arr, i, j);
                    }
                }
            }
            r--;
            for (int i = r - 1; i > l + 1; i--) {
                for (int j = i - 1; j > l; j--) {
                    if (arr[i] > arr[j]) {
                        isSorted = false;
                        swap(arr, i, j);
                    }
                }
            }
            l++;

        }
        return arr;
    }

    public static int[] bubleSort(int[] arr) {
        boolean isSorted = false;
        for (int i = 0; !isSorted && i < arr.length - 2; i++) {
            isSorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                    isSorted = false;
                }
            }
        }
        return arr;
    }

    public static int[] insertionSortSedj(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] > arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    public static int[] insertionSortMTI(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0 && tmp > arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static int getMinInd(int[] arr, int start, int end) {
        int minInd = start;
        for (int i = start + 1; i < end; i++) {
            if (arr[minInd] > arr[i]) {
                minInd = i;
            }
        }
        return minInd;
    }

    public static int getMaxInd(int[] arr, int start, int end) {
        int maxInd = start;
        for (int i = start + 1; i < end; i++) {
            if (arr[maxInd] < arr[i]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, i, getMinInd(arr, i, arr.length));
        }
        return arr;
    }

    public static int[] shellSortKnut(int arr[]) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i;
                while (j > h - 1 && arr[j - h] > tmp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = tmp;
            }
            h /= 3;
        }
        return arr;
    }

    public static int[] shellSortSej(int[] arr) {
        for (int gap = arr.length >> 2; gap > 0; gap >>= 1) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i;
                for (j = i; j > gap - 1 && arr[j - gap] > tmp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
        return arr;
    }

    public static int[] countingSort(int[] arr) {
        int[] counts = new int[arr[getMaxInd(arr, 0, arr.length)] + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        for (int i = 0, j = 0; i < counts.length; i++) {
            for (int k = 0; k < counts[i]; j++, k++) {
                arr[j] = i;
            }
        }
        return arr;
    }

    public static int[] countingSortStable(int[] arr) {
        int[] counts = new int[arr[getMaxInd(arr, 0, arr.length)] + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        int[] brr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            brr[counts[arr[i]] - 1] = arr[i];
            counts[arr[i]]--;
        }
        return brr;
    }

    public static int[] bitRadixSort(int[] arr) {
        int mask = 1;
        int bits = Integer.SIZE;
        int N = arr.length;

        for (int d = 0; d < bits; d++) {
            int[] out = new int[N];
            int[] count = new int[2];

            // compute frequency counts
            for (int i = 0; i < N; i++) {
                int bit = (arr[i] >> d) & mask;
                if (d == bits - 1) {
                    bit ^= mask;
                }
                count[bit]++;
            }
            if (count[0] != 0 && count[1] != 0) {

                for (int i = 1; i < count.length; i++)
                    count[i] += count[i - 1];

                for (int i = arr.length - 1; i >= 0; i--) {
                    int bit = (arr[i] >> d) & mask;
                    if (d == bits - 1) {
                        bit ^= mask;
                    }
                    count[bit]--;
                    out[count[bit]] = arr[i];
                }
                // copy aux'elements back to arr'elements
                System.arraycopy(out, 0, arr, 0, arr.length);
            }
        }
        return arr;
    }

    public static int[] radixSort(int[] arr, int base, int d) {
        int maxPos = (int) Math.pow(base, d);
        for (int pos = 1; pos <= maxPos; pos *= base) {
            int[] counts = new int[base];
            int[] out = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                counts[(arr[i] / pos) % base]++;
            }
            for (int i = 1; i < base; i++) {
                counts[i] += counts[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = arr[i] / pos % base;
                out[counts[digit] - 1] = arr[i];
                counts[digit]--;
            }
            //copy
            System.arraycopy(out, 0, arr, 0, arr.length);
        }
        return arr;
    }

    public static String[] strRadixSort(String[] in, int len) {
        int alphabetSize = 26;
        String[] out = new String[in.length];

        for (int pos = len - 1; pos >= 0; pos--) {

            int[] counts = new int[alphabetSize];
            for (int i = 0; i < in.length; i++) {
                counts[Character.toLowerCase(in[i].charAt(pos)) - 'a']++;
            }
            for (int i = 1; i < alphabetSize; i++) {
                counts[i] += counts[i - 1];
            }
            for (int i = in.length - 1; i >= 0; i--) {
                int ind = Character.toLowerCase(in[i].charAt(pos)) - 'a';
                counts[ind]--;
                out[counts[ind]] = in[i];
            }
            System.arraycopy(out, 0, in, 0, in.length);
        }
        return in;
    }

    public static int[] bucketSort(int[] arr) {
        int max = arr[getMaxInd(arr, 0, arr.length)] + 1;
        DLNode[] buckets = new DLNode[arr.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        for (int i = 0; i < arr.length; i++) {
            int ind = (int) (buckets.length * arr[i] / (double) max);
            buckets[ind] = ListSort.insertToSortedList(buckets[ind], new DLNode(arr[i]));
        }
        for (int i = 0, j = 0; j < buckets.length; j++) {
            while (buckets[j] != null) {
                arr[i++] = buckets[j].data;
                buckets[j] = DLNode.removeFirst(buckets[j]);
            }
        }
        return arr;
    }
//    public static int[] mergeSortButtom(int[] arr){
//        int size=1;
//        while (size<arr.length){
//            int p=0;
//            while(p<=arr.length-size){
//                int q=p+size;
//                int A[] =new int[q-1-p];
//                int B[] =new int[q-1-p];
//                arr=int[]  A=new int[];
//                merge();
//            }
//
//        }
//        return arr;
//    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length > 1) {
            int m = arr.length / 2;
            int A[] = new int[m];
            int B[] = new int[arr.length - m];
            System.arraycopy(arr, 0, A, 0, m);
            System.arraycopy(arr, m, B, 0, B.length);
            A = mergeSort(A);
            B = mergeSort(B);
            return merge(A, B);
        } else {
            return arr;
        }
    }

    private static int[] merge(int[] A, int[] B) {
        int C[] = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < A.length && k < B.length) {
            if (A[j] < B[k]) {
                C[i] = A[j];
                j++;
            } else {
                C[i] = B[k];
                k++;
            }
            i++;
        }
        if (j < A.length) {
            System.arraycopy(A, j, C, i, A.length - j);
        } else {
            System.arraycopy(B, k, C, i, B.length - k);
        }
        return C;
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot=arr[r];
        int i=l-1;
        for(int j=l; j<r;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);

            }
        }
        swap(arr,i+1,r);
        return i+1;
    }

    public static int[] quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
//            System.out.println(pivot+" ");
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
        return arr;
    }
}
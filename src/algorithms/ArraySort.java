package algorithms;

import stuctures.DLNode;

import static algorithms.ArrayOperations.swap;

/**
 * Created by Zulus on 13.01.2017.
 */
public class ArraySort {
    /**
     * пузырьковая соритировка с двух концов
     *
     * @param arr
     * @return
     */
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

    /**
     * пузырьковая соритировка
     *
     * @param arr
     * @return
     */
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

    /**
     * соритировка вставкой (Седжвик)
     *
     * @param arr
     * @return
     */
    public static int[] insertionSortSedj(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] > arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    /**
     * соритировка вставкой(МТИ)
     *
     * @param arr
     * @return
     */
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

    /**
     * поиск минимального значения в массиве
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int getMinInd(int[] arr, int start, int end) {
        int minInd = start;
        for (int i = start + 1; i < end; i++) {
            if (arr[minInd] > arr[i]) {
                minInd = i;
            }
        }
        return minInd;
    }

    /**
     * поиск максимального значения в массиве
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int getMaxInd(int[] arr, int start, int end) {
        int maxInd = start;
        for (int i = start + 1; i < end; i++) {
            if (arr[maxInd] < arr[i]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    /**
     * соритировка выборкой
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, i, getMinInd(arr, i, arr.length));
        }
        return arr;
    }

    /**
     * соритировка Шелла ( по Кнуту)
     *
     * @param arr
     * @return
     */
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

    /**
     * соритировка Шелла по Седжвику
     *
     * @param arr
     * @return
     */
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

    /**
     * соритировка подсчетом (не стойкая)
     *
     * @param arr
     * @return
     */
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

    /**
     * соритировка подсчетом ( стойкая)
     *
     * @param arr
     * @return
     */
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

    /**
     * поразрядная сортировка
     *
     * @param arr
     * @return
     */
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

    /**
     * поразрядная соритировка
     *
     * @param in
     * @param len
     * @return
     */
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

    /**
     * соритировка ячейками
     *
     * @param arr
     * @return
     */
    public static int[] bucketSort(int[] arr) {
        int max = arr[getMaxInd(arr, 0, arr.length)] + 1;
        DLNode[] buckets = new DLNode[arr.length];
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

    /**
     * Сортировка слиянием, двоколейное слияние, top-down
     *
     * @param arr
     */
    public static void mergesortTD(int[] arr) {
        mergesortTD(arr, 0, arr.length - 1);
    }

    private static void mergesortTD(int[] arr, int L, int R) {
        if (L < R) {
            int M = (R + L) / 2;
            mergesortTD(arr, L, M);
            mergesortTD(arr, M + 1, R);
            merge(arr, L, M, R);
        }
    }

    private static void merge(int[] dst, int L, int M, int R) {
        int[] left = new int[M - L + 1];
        int[] right = new int[R - M];
        System.arraycopy(dst, L, left, 0, left.length);
        System.arraycopy(dst, M + 1, right, 0, right.length);
        for (int k = L, i = 0, j = 0; k <= R; k++) {
            if (i == left.length) {
                //check, is left array is empty
                dst[k] = right[j++];
            } else if (j == right.length) {
                //check, is right array is empty
                dst[k] = left[i++];
            } else if (left[i] <= right[j]) {
                //copy element from left subarray
                dst[k] = left[i++];
            } else {
                //copy element from right subarray
                dst[k] = right[j++];
            }
        }
    }

    /**
     * merger sort Bottom-Up
     *
     * @param arr
     */
    public static void mergesortBD(int arr[]) {
        int chunk = 1;
        while (chunk < arr.length) {
            int pos = 0;
            while (pos <= arr.length - chunk) {
                int mid = pos + chunk - 1;
                merge(arr, pos, mid, Integer.min(mid + chunk, arr.length - 1));
                pos += chunk * 2;
            }
            chunk *= 2;
        }
    }

    /**
     * quicksort by Lomuto's algorithm
     *
     * @param arr
     */
    public static void quicksortL(int arr[]) {
        quicksortL(arr, 0, arr.length - 1);
    }

    private static int partition_L(int arr[], int L, int R) {
        //last element is pivot
        int pivot = arr[R];
        //index of end of lower part
        int i = L - 1;
        for (int j = L; j <= R - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, R);
        return i;
    }

    private static void quicksortL(int arr[], int L, int R) {
        if (L < R) {
            int q = partition_L(arr, L, R);
            quicksortL(arr, L, q - 1);
            quicksortL(arr, q + 1, R);
        }
    }

    /**
     * quicksort by Hoar's partition
     *
     * @param arr
     */
    public static void quicksortH(int arr[]) {
        quicksortH(arr, 0, arr.length - 1);
    }

    private static int partition_H(int arr[], int L, int R) {
        int pivot = arr[L];
        int left = L;
        int right = R + 1;

        while (true) {

            // decrement the r pointer until you meet the pivot
            while (left < --right && arr[right] > pivot) ;
            // increment the p pointer until you meet the pivot
            while (++left < right && arr[left] < pivot) ;
            // if the pointers have crossed, swap the items
            if (left >= right)
                break;
            swap(arr, left, right);
        }
        // swap pivot and the end of less part
        swap(arr, right, L);
        return right;
    }

    private static void quicksortH(int arr[], int L, int R) {
        if (L < R) {
            int q = partition_H(arr, L, R);
            quicksortH(arr, L, q - 1);
            quicksortH(arr, q+1, R);
        }
    }
}
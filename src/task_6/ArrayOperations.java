package task_6;

import java.util.Random;

/**
 * Created by Zulus on 13.01.2017.
 */
public class ArrayOperations {
    public static int[] getRandomizeArray(int size, int min, int max) {
        int[] arr = new int[size];
        Random rnd = new Random();
        max -= min;
        for (int i = 0; i < size; i++) {
            arr[i] = min + rnd.nextInt(max);
        }
        return arr;
    }

    public static int find(int[] arr, int val) {
        int i = 0;
        for (i = arr.length; i >= 0 && arr[i] != val; i--) ;
        return i;
    }

    public static void printArray(String[] star) {

        for (int i = 0; i < star.length; i++) {
            System.out.print(star[i] + " ");
        }
        System.out.println();
    }

    public static long getMultiply(int[] arr) {
        long m = 1;
        for (int a : arr) {
            m *= a;
        }
        return m;
    }

    public static long getSum(int[] arr) {
        long sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }

    public static double getAverage(int[] arr) {
        if (arr.length == 0) {
            return Double.NaN;
        }
        return getSum(arr) / (double) arr.length;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int buf = arr[i];
            arr[i] = arr[j];
            arr[j] = buf;
        }
    }

    public static int[] getArray(int size, int start) {
        if (size < 0) size = 0;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = start + i;
        }
        return arr;
    }

    public static int[] shuffle(int[] arr) {
        Random rnd = new Random();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            swap(arr, i, rnd.nextInt(size));
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) System.out.println("The array is empty");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d]%d ", i, arr[i]);
        }
        System.out.println();
    }

    public static void printArray(long[] arr) {
        if (arr.length == 0) System.out.println("The array is empty");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d]%d ", i, arr[i]);
        }
        System.out.println();
    }

    public static int[] reverse(int[] arr) {
        for (int i = 0, mid = arr.length >> 1, j = arr.length - 1; i < mid; i++, j--) {
            swap(arr, i, j);
        }
        return arr;
    }

    public static long[] getFibonachi(int count) {
        long[] arr = new long[count];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < count; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int[] getPrimeNumbers(int max) {
        int start = 2;
        int count = 0;
        int arr[] = getArray(max + 1, 0);

        for (int i = start; i < arr.length; i++) {
            if (arr[i] != 0) {
                count++;
                for (int j = i * i; j < arr.length; j += arr[i]) {
                    arr[j] = 0;
                }
            }
        }
        if (count == 0) return new int[0];
        int[] primeArray = new int[count + 1];
        for (int i = 0, j = 0; j <= count; i++) {
            if (arr[i] != 0) primeArray[j++] = arr[i];
        }
        return primeArray;
    }
}

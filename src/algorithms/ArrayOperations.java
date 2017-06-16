package algorithms;

import java.util.Random;

/**
 * Created by Zulus on 13.01.2017.
 */
public class ArrayOperations {
    /**
     * получить рандомизированный массив int
     *
     * @param size
     * @param min
     * @param max
     * @return
     */
    public static int[] getRandomizeArray(int size, int min, int max) {
        int[] arr = new int[size];
        Random rnd = new Random();
        max -= min;
        for (int i = 0; i < size; i++) {
            arr[i] = min + rnd.nextInt(max);
        }
        return arr;
    }

    /**
     * линейный поиск
     *
     * @param arr
     * @param val
     * @return
     */
    public static int indexOf(int[] arr, int val) {
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

    /**
     * получить произведение всех элементов
     *
     * @param arr
     * @return
     */
    public static long getMultiply(int[] arr) {
        long m = 1;
        for (int a : arr) {
            m *= a;
        }
        return m;
    }

    /**
     * получить сумму элементов
     *
     * @param arr
     * @return
     */
    public static long getSum(int[] arr) {
        long sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }

    /**
     * среднее значение элементов массива
     *
     * @param arr
     * @return
     */
    public static double getAverage(int[] arr) {
        if (arr.length == 0) {
            return Double.NaN;
        }
        return getSum(arr) / (double) arr.length;
    }

    /**
     * поменять элементы местами
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int buf = arr[i];
            arr[i] = arr[j];
            arr[j] = buf;
        }
    }

    public static  String[] getStrArray(int size,  int minLength,int maxLength){
        String[] arr=new String[size];
        for(int j=0; j<size;j++){
            int bound=(int)(Math.random()*(maxLength-minLength)+minLength);
            arr[j]="";
            for(int i=0; i<bound;i++){
                arr[j]+=(char)('A'+Math.random()*27);
            }
        }
        return arr;
    }
    /**
     * получить массив заполненый числами по возрастанию, начиная со start
     *
     * @param size
     * @param start
     * @return
     */
    public static int[] getArray(int size, int start) {
        if (size < 0) size = 0;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = start + i;
        }
        return arr;
    }

    /**
     * перемешать массив
     *
     * @param arr
     * @return
     */
    public static int[] shuffle(int[] arr) {
        Random rnd = new Random();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            swap(arr, i, rnd.nextInt(size));
        }
        return arr;
    }

    public static void printArray(final int[] arr) {
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

    /**
     * реверс массива
     *
     * @param arr
     * @return
     */
    public static int[] reverse(int[] arr) {
        for (int i = 0, mid = arr.length >> 1, j = arr.length - 1; i < mid; i++, j--) {
            swap(arr, i, j);
        }
        return arr;
    }

    private static boolean isSorted_decr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isSorted_incr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSorted(int[] arr, boolean byIncrease) {
        if (byIncrease) {
            return isSorted_incr(arr);
        } else {
            return isSorted_decr(arr);
        }
    }
}

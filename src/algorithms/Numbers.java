package algorithms;

import static algorithms.ArrayOperations.getArray;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by elena on 6/15/2017.
 */
public class Numbers {
    /**
     * найти НОД в цикле
     *
     * @param m
     * @param n
     * @return
     */
    public static int getGCDByBust(int m, int n) {
        int t = min(m, n);
        while (t != 0) {
            if (m % t == 0 && n % t == 0) return t;
            else t--;
        }
        return max(m, n);
    }

    /**
     * найти НОД методом Эвклида
     *
     * @param m
     * @param n
     * @return
     */
    public static int getGCDByEuclid(int m, int n) {
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    /**
     * получить count чисел Фибоначи
     *
     * @param count
     * @return
     */
    public static long[] getFibonachi(int count) {
        long[] arr = new long[count];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < count; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * получить все простые числа в диапазоне (2; max)
     *
     * @param max
     * @return
     */
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

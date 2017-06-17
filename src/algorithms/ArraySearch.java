package algorithms;

/**
 * Created by elena on 6/15/2017.
 */
public class ArraySearch {
    /**
     * бинарный поиск
     *
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int key) {
        int r = arr.length - 1;
        int l = 0;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == key) {
                return m;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    /**
     * интерполяционный поиск
     *
     * @param arr
     * @param key
     * @return
     */
    public static int interpolSearch(int arr[], int key) {
        int r = arr.length - 1;
        int l = 0;
        int m;
        while (l <= r) {
            m = l + (key - arr[l]) * (r - l) / (arr[r] - arr[l]);
            if (m >= arr.length || m < 0) return -1;
            if (arr[m] == key) {
                return m;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    /**
     * линейный поиск
     *
     * @param arr
     * @param key
     * @return
     */
    public static int linearSeatch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * экспотенциальный поиск
     *
     * @param arr
     * @param key
     * @return
     */
    public static int expSearch(int arr[], int key) {
        int r = 1;
        int l = 0;
        int m;
        while (arr[r] < key) {
            r <<= 1;
        }
        l = r / 2;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == key) {
                return m;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}

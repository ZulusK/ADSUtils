package task_1;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by Zulus on 12.01.2017.
 */
public class FindHCF {
    public static int getGCDByBust(int m, int n) {
        int t = min(m, n);
        while (t != 0) {
            if (m % t == 0 && n % t == 0) return t;
            else t--;
        }
        return max(m,n);
    }

    public static int getGCDByEuclid(int m, int n) {
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
}

package xyz.nyist.leetcode.begin800;

/**
 * @author: silence
 * @Date: 2022/11/22 08:54
 * @Description:
 */
public class Solution878 {
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1000000007;

        long c = (long) a * b / goc(a, b);

        long l = Math.min(a, b), r = l * n;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long t = mid / a + mid / b - mid / c;
            System.out.println(mid + " " + t);
            if (n > t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return (int) (l % MOD);
    }

    private int goc(int a, int b) {
        return b == 0 ? a : goc(b, a % b);
    }

}

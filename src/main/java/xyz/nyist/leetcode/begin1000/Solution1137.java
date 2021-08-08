package xyz.nyist.leetcode.begin1000;

/**
 * @author: fucong
 * @Date: 2021/8/8 21:41
 * @Description:
 */
public class Solution1137 {

    public int tribonacci(int n) {

        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        for (int i = 3; i <= n; i++) {
            int k = i % 3;
            if (k == 0) {
                t0 = t0 + t1 + t2;
            } else if (k == 1) {
                t1 = t0 + t1 + t2;
            } else {
                t2 = t0 + t1 + t2;
            }
        }
        int k = n % 3;
        if (k == 0) {
            return t0;
        } else if (k == 1) {
            return t1;
        } else {
            return t2;
        }

    }

}

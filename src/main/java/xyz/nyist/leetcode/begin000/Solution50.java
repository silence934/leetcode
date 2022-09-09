package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/9/8 16:17
 * @Description: <a href="https://leetcode.cn/problems/powx-n/">...</a>
 */
public class Solution50 {

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        System.out.println(solution50.myPow(2.0, 11));
    }

    public double myPow(double x, int n) {
        return n > 0 ? myPow1(x, n) : 1 / myPow1(x, n);
    }

    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }

        double v = myPow1(x, n / 2);

        return ((n & 1) == 1) ? v * v * x : v * v;
    }

}

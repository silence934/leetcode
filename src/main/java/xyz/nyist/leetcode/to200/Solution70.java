package xyz.nyist.leetcode.to200;

/**
 * @Author: silence
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * @Date:Create：in 2020/6/13 21:46
 */
public class Solution70 {

    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}

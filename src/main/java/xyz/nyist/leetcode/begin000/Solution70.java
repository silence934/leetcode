package xyz.nyist.leetcode.begin000;

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

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(3));
    }

    public int climbStairs(int n) {
        int x = 1, y = 2;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                y = x + y;
            } else {
                x = x + y;
            }
        }

        return n % 2 == 0 ? y : x;
    }

}

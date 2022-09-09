package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2021/9/18 14:49
 * @Description:
 */
public class Solution746 {


    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];


        double d = 1;
        System.out.println(d);

        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }


        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

}

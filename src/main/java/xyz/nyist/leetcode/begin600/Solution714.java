package xyz.nyist.leetcode.begin600;

/**
 * @author: fucong
 * @Date: 2021/7/2 19:30
 * @Description:
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        dp[0][0] = 0;
        dp[1][0] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i] - fee);
        }


        return dp[0][prices.length - 1];
    }
}

package xyz.nyist.leetcode.begin200;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/10 21:55
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        dp[0][1] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 2] - prices[i]);
        }


        return dp[0][prices.length - 1];
    }

    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        System.out.println(solution309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}

package xyz.nyist.leetcode.begin000;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/5 11:42
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
    }


    public int maxProfit1(int[] prices) {
        int[][][] dp = new int[2][prices.length][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[1][0][1] = -prices[0];
        dp[1][0][0] = Integer.MIN_VALUE;


        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k < 2; k++) {
                dp[0][i][k] = Math.max(dp[0][i - 1][k], dp[1][i - 1][k] + prices[i]);
                dp[1][i][k] = Math.max(dp[1][i - 1][k], dp[0][i - 1][k - 1] - prices[i]);
            }
        }

        return Math.max(dp[0][prices.length - 1][1], dp[0][prices.length - 1][0]);
    }


}

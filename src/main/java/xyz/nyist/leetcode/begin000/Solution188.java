package xyz.nyist.leetcode.begin000;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/14 17:57
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        } else if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        k++;
        int NO = Integer.MIN_VALUE / 2;
        int[][][] dp = new int[prices.length][k][2];
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                dp[0][i][0] = 0;
                dp[0][i][1] = NO;
            } else if (i == 1) {
                dp[0][i][0] = NO;
                dp[0][i][1] = -prices[0];
            } else {
                dp[0][i][0] = NO;
                dp[0][i][1] = NO;
            }
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = NO;
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, dp[prices.length - 1][i][0]);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        System.out.println(solution188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(solution188.maxProfit1(2, new int[]{3, 2, 6, 5, 0, 3}));
    }


    public int maxProfit1(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int no = Integer.MIN_VALUE / 2;

        int[] p0 = new int[k + 1];
        int[] p1 = new int[k + 1];

        for (int i = 0; i < k + 1; i++) {
            if (i == 0) {
                p0[0] = 0;
                p1[0] = no;
            } else if (i == 1) {
                p0[1] = no;
                p1[1] = -prices[0];
            } else {
                p0[i] = no;
                p1[i] = no;
            }
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                int t = p0[j - 1];
                p0[j] = Math.max(p0[j], p1[j] + prices[i]);
                p1[j] = Math.max(p1[j], t - prices[i]);
            }
        }


        int max = -1;
        for (int i = 0; i < k + 1; i++) {
            max = Math.max(p0[i], max);
        }

        return max;
    }
}

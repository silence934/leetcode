package xyz.nyist.leetcode.begin000;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 18:06
 */
public class Solution123 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int NO = Integer.MIN_VALUE / 2, k = 3;
        int[][][] dp = new int[prices.length][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = NO;
        dp[0][1][0] = NO;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = NO;
        dp[0][2][1] = NO;
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
           /* dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = NO;
            dp[i][1][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][1] + prices[i], dp[i - 1][2][0]);
            dp[i][2][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][2][1]);*/
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, dp[prices.length - 1][i][0]);
        }
        return max;
    }


    public void show(int[][][] dp, int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.println("第" + i + "天 ");
            for (int j = 0; j < 3; j++) {
                System.out.println(" 交易次数 " + j);
                for (int k = 0; k < 2; k++) {
                    System.out.println("  状态 " + k + " 金额" + dp[i][j][k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        System.out.println(solution123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(solution123.maxProfit1(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public int maxProfit1(int[] prices) {

        int[][][] dp = new int[2][prices.length][3];

        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE / 2;
        dp[0][0][2] = Integer.MIN_VALUE / 2;
        dp[1][0][0] = Integer.MIN_VALUE / 2;
        dp[1][0][1] = -prices[0];
        dp[1][0][2] = Integer.MIN_VALUE / 2;


        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k < 3; k++) {
                dp[0][i][k] = Math.max(dp[0][i - 1][k], dp[1][i - 1][k] + prices[i]);
                dp[1][i][k] = Math.max(dp[0][i - 1][k - 1] - prices[i], dp[1][i - 1][k]);
            }
        }

        int max = -1;
        for (int i = 0; i < 3; i++) {
            max = Math.max(dp[0][prices.length - 1][i], max);
        }

        return max;
    }


    public int maxProfit2(int[] prices) {
        //天数  是否有股票  买入次数
        int[][][] dp = new int[prices.length][2][3];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE / 2;
        dp[0][0][2] = Integer.MIN_VALUE / 2;
        dp[0][1][0] = Integer.MIN_VALUE / 2;
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = Integer.MIN_VALUE / 2;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][2] + prices[i]);
            dp[i][1][0] = Integer.MIN_VALUE / 2;
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][2] = Math.max(dp[i - 1][1][2], dp[i - 1][0][1] - prices[i]);
        }

        return Math.max(dp[prices.length - 1][0][0], Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
    }

}

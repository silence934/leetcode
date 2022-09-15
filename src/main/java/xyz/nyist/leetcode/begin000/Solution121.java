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


    public int maxProfit2(int[] prices) {
        //第几天  手上有无股票  交易次数
        int[][][] dp = new int[prices.length][2][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //当前手上没有股票，也没有交易过  只能是前一天也没交易过
            dp[i][0][0] = dp[i - 1][0][0];
            //当前手上没有股票  交易过一次  可以是其一天就是这种状态，或者前一天有股票今天给卖了
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1] + prices[i]);
            //不存在这种可能
            dp[i][1][0] = Integer.MIN_VALUE;
            //前一天就是这种状态,或者今天买了股票
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
        }

        return Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][0]);
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

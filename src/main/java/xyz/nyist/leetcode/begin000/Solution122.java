package xyz.nyist.leetcode.begin000;

/**
 * @Author: silence
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/11 17:52
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        System.out.println(solution122.maxProfit2(new int[]{1, 2, 3, 4, 5}));
    }

    public int maxProfit1(int[] prices) {
        int[][] dp = new int[2][prices.length];

        dp[0][0] = 0;
        dp[1][0] = -prices[0];


        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
        }

        return dp[0][prices.length - 1];
    }

    public int maxProfit2(int[] prices) {

        int p1 = 0;
        int p2 = -prices[0];


        for (int i = 1; i < prices.length; i++) {
            int t = p1;
            p1 = Math.max(t, p2 + prices[i]);
            p2 = Math.max(p2, t - prices[i]);
        }

        return p1;
    }
}

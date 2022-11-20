package xyz.nyist.leetcode.begin800;

/**
 * @author: silence
 * @Date: 2022/11/20 13:40
 * @Description:
 */
public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            dp[i][0] = Math.max((dp[i - 1][0] - 1) / 2, 0);
            dp[i][i] = Math.max((dp[i - 1][i - 1] - 1) / 2, 0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max((dp[i - 1][j - 1] - 1) / 2, 0) + Math.max((dp[i - 1][j] - 1) / 2, 0);
            }
        }

        return Math.min(dp[query_row][query_glass], 1.0);
    }
}

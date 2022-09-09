package xyz.nyist.leetcode.begin200;

/**
 * @author: silence
 * @Date: 2021/7/11 18:23
 * @Description:
 */
public class Solution279 {

    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(12));
    }

    public int numSquares(int n) {
        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i >= j * j) {
                    if (dp[i] != null) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                    } else {
                        dp[i] = 1 + dp[i - j * j];
                    }
                }
            }
        }

        return dp[n];
    }

}

package xyz.nyist.leetcode.begin1200;

/**
 * @author: silence
 * @Date: 2021/7/23 16:05
 * @Description:
 */
public class Solution1312 {

    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }

}

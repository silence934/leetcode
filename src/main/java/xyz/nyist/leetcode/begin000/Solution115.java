package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/7/10 12:09
 * @Description:
 */
public class Solution115 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j] + (j == 0 ? 1 : dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length() - 1][t.length() - 1];
    }

}

package xyz.nyist.leetcode.begin400;

/**
 * @author: silence
 * @Date: 2021/7/4 18:37
 * @Description:
 */
public class Solution583 {

    Integer[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        int maxLen = test(word1, 0, word2, 0);
        return word1.length() - maxLen + (word2.length() - maxLen);
    }


    private int test(String s1, int i, String s2, int j) {
        if (s1.length() == i || s2.length() == j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + test(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.max(test(s1, i, s2, j + 1), test(s1, i + 1, s2, j));
        }
        return memo[i][j];
    }


    public int minDistance1(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i, j);
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }

}

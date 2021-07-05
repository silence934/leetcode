package xyz.nyist.leetcode.begin400;

/**
 * @author: fucong
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

}

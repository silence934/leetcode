package xyz.nyist.leetcode.begin1000;

/**
 * @author: silence
 * @Date: 2021/7/2 11:36
 * @Description:
 */
public class Solution1143 {

    Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return test(text1, 0, text2, 0);
    }


    private int test(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
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

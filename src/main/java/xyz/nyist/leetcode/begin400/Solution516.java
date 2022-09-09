package xyz.nyist.leetcode.begin400;

/**
 * @author: silence
 * @Date: 2021/7/4 19:37
 * @Description:
 */
public class Solution516 {

    public static void main(String[] args) {
        Solution516 solution516 = new Solution516();
        System.out.println(solution516.longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        //i<=j
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }


        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }


        return dp[0][s.length() - 1];
    }


}

package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2021/7/7 18:42
 * @Description:
 */
public class Solution72 {

    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        System.out.println(solution72.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i][j - 1], dp[i - 1][j]) + 1,
                            dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
                }
            }
        }
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];
    }

}

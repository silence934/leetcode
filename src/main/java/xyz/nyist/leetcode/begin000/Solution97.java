package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2021/7/9 20:04
 * @Description:
 */
public class Solution97 {

    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new Boolean[s1.length()][s2.length()];


        return test(s1, 0, s2, 0, s3);
    }

    private boolean test(String s1, int p1, String s2, int p2, String s3) {
        if (s1.length() == p1 && s2.length() == p2) {
            return true;
        } else if (s1.length() == p1) {
            return s2.substring(p2).equals(s3.substring(p1 + p2));
        } else if (s2.length() == p2) {
            return s1.substring(p1).equals(s3.substring(p1 + p2));
        }

        if (memo[p1][p2] != null) {
            return memo[p1][p2];
        }

        int index = p1 + p2;

        boolean b = false;
        if (s1.charAt(p1) == s3.charAt(index)) {
            b = test(s1, p1 + 1, s2, p2, s3);
        }
        if (s2.charAt(p2) == s3.charAt(index)) {
            b = b || test(s1, p1, s2, p2 + 1, s3);
        }
        memo[p1][p2] = b;
        return memo[p1][p2];
    }


    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length(); i > -1; i--) {
            for (int j = s2.length(); j > -1; j--) {
                if (i == s1.length() && j == s2.length()) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (i != s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) ||
                            (j != s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

}

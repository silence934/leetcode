package xyz.nyist.leetcode.begin600;

/**
 * @author: fucong
 * @Date: 2021/7/4 18:49
 * @Description:
 */
public class Solution712 {

    Integer[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        memo = new Integer[s1.length()][s2.length()];
        return test(s1, 0, s2, 0);
    }


    private int test(String s1, int i, String s2, int j) {
        if (s1.length() == i) {
            int res = 0;
            for (; j < s2.length(); j++) {
                res += s2.charAt(j);
            }
            return res;
        }
        if (s2.length() == j) {
            int res = 0;
            for (; i < s1.length(); i++) {
                res += s1.charAt(i);
            }
            return res;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = test(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(s1.charAt(i) + test(s1, i + 1, s2, j), s2.charAt(j) + test(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }


}

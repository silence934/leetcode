package xyz.nyist.leetcode.to200;

/**
 * @Author: silence
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/4 17:58
 */

public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int start = 0, maxL = 1, t, p;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                p = i + j;
                if (p == j) {
                    dp[j][p] = true;
                    continue;
                }
                if (j + 1 == p) {
                    if (s.charAt(j) == s.charAt(p)) {
                        dp[j][p] = true;
                        if ((t = p - j + 1) > maxL) {
                            maxL = t;
                            start = j;
                        }
                    }
                }
                else if (dp[j + 1][p - 1] && s.charAt(j) == s.charAt(p)) {
                    dp[j][p] = true;
                    if ((t = p - j + 1) > maxL) {
                        maxL = t;
                        start = j;
                    }
                }

            }
        }
        return s.substring(start, start + maxL);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("bb"));
    }
}


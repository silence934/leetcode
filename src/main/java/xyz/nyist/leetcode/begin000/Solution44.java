package xyz.nyist.leetcode.begin000;

/**
 * @Author: silence
 * @Description: 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/23 11:15
 */
public class Solution44 {

    public boolean isMatch(String s, String p) {
        if (p.equals(s) || "*".equals(p)) {
            return true;
        }
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        if (p.length() > 1) {
            StringBuilder sb = new StringBuilder().append(p.charAt(0));
            for (int i = 1; i < p.length(); i++) {
                if (p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
                    continue;
                }
                sb.append(p.charAt(i));
            }
            p = "#" + sb;
        } else {
            p = "#" + p;
        }
        s = "#" + s;
        int ls = s.length(), lp = p.length();
        char[] sa = s.toCharArray(), pa = p.toCharArray();
        boolean[][] dp = new boolean[ls][lp];
        dp[0][0] = true;
        dp[0][1] = pa[1] == '*';
        for (int i = 1; i < ls; i++) {
            for (int j = 1; j < lp; j++) {
                if (pa[j] != '*') {
                    dp[i][j] = (sa[i] == pa[j] || pa[j] == '?') && dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[ls - 1][lp - 1];
    }


    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        long start = System.currentTimeMillis();
        System.out.println(solution44.isMatch("", ""));
        System.out.println(System.currentTimeMillis() - start);
    }


}

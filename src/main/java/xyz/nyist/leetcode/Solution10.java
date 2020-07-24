package xyz.nyist.leetcode;

/**
 * @Author: silence
 * @Description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/20 23:22
 */
public class Solution10 {

    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        return get(sArr.length - 1, pArr.length - 1, sArr, pArr);
    }

    public boolean get(int j, int k, char[] sArr, char[] pArr) {
        if (j < 0 || k < 0) {
            return false;
        }
        if (j == 0 && 0 == k && (sArr[j] == pArr[k] || pArr[k] == '.')) {
            return true;
        }
        if (pArr[k] == '*') {
            if (sArr[j] != pArr[k - 1] && pArr[k - 1] != '.') {
                return get(j, k - 2, sArr, pArr);
            }
            else {
                return get(j - 1, k, sArr, pArr) || get(j, k - 2, sArr, pArr);
            }
        }
        else if (sArr[j] == pArr[k] || pArr[k] == '.') {
            return get(j - 1, k - 1, sArr, pArr);
        }
        return false;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.isMatch("ab",
                ".*"));
        System.out.println(System.currentTimeMillis() - start);
    }

    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}

package xyz.nyist.leetcode.to800;

import java.util.ArrayList;

/**
 * @Author : fucong
 * @Date: 2020-08-27 16:15
 * @Description :
 * 求出大于或等于 N 的最小回文素数。
 * <p>
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * <p>
 * 例如，2，3，5，7，11 以及 13 是素数。
 * <p>
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * <p>
 * 例如，12321 是回文数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：6
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：8
 * 输出：11
 * 示例 3：
 * <p>
 * 输入：13
 * 输出：101
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution866 {
    public int primePalindrome(int N) {
        while (!isH(N) || !isS(N)) {
            N++;
        }
        return N;
    }

    private static boolean isH(int i) {
        String str = String.valueOf(i);
        char[] chars = str.toCharArray();
        int s = 0, e = chars.length - 1;
        while (s < e) {
            if (chars[s++] != chars[e--]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isS(int i) {
        if (i == 1) {
            return false;
        }
        int k = (int) Math.sqrt(i);
        for (int j = 2; j <= k; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    static int nextPar(String N) {
        int len = N.length();
        int half = Integer.valueOf(N.substring(0, (len + 1) / 2));
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = half; i < half + 2; i++) {
            String halfStr = "" + i;
            if (len % 2 == 1) {
                halfStr = halfStr.substring(0, halfStr.length() - 1);
            }
            int ret = Integer.valueOf("" + i + new StringBuilder(halfStr).reverse().toString());
            res.add(ret);
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) >= Integer.valueOf(N)) {
                return res.get(i);
            }
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        System.out.println(nextPar("9989900"));
        Solution866 solution866 = new Solution866();
        System.out.println(solution866.primePalindrome(9989900));
    }
}

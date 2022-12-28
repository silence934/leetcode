package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/28 16:54
 * @Description: bcbcb
 */
public class Solution1750 {
    public static void main(String[] args) {
        System.out.println(new Solution1750().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

    public int minimumLength(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char c = s.charAt(0);
        int l = 1, r = s.length() - 1;
        while (l < s.length() && s.charAt(l) == c) {
            l++;
        }

        while (r > -1 && s.charAt(r) == c) {
            r--;
        }

        if (r == s.length() - 1) {
            return s.length();
        } else if (r <= l) {
            return Math.max(0, r - l + 1);
        }

        return minimumLength(s.substring(l, r + 1));
    }
}

package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2021/9/16 19:24
 * @Description:
 */
public class Solution8 {

    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi("   +0 123"));

    }

    public int myAtoi(String s) {
        int start = -1, end = 0;

        int k = 0;

        Boolean b = null;

        while (k < s.length()) {
            if (start == -1) {
                if (s.charAt(k) == ' ' && b == null) {

                } else if (s.charAt(k) == '-') {
                    if (b != null) {
                        return 0;
                    }
                    b = false;
                } else if (s.charAt(k) == '+') {
                    if (b != null) {
                        return 0;
                    }
                    b = true;
                } else if ((s.charAt(k) >= '1' && s.charAt(k) <= '9')) {
                    if (b == null) {
                        b = true;
                    }
                    start = k;
                } else if (s.charAt(k) == '0') {
                    if (b == null) {
                        b = true;
                    }
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(k) >= '0' && s.charAt(k) <= '9' && k - start < 12) {
                } else {
                    end = k;
                    break;
                }
            }
            k++;

        }

        if (start == -1) {
            return 0;
        }

        if (end == 0) {
            end = k;
        }

        if (end - start == 1 && (s.charAt(start) == '-' || s.charAt(start) == '+')) {
            return 0;
        }

        long l = Long.parseLong(s.substring(start, end));

        l = !b ? -l : l;

        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) l;
        }
    }

}

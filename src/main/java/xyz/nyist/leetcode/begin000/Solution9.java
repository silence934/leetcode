package xyz.nyist.leetcode.begin000;

/**
 * @Author: silence
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Date:Create：in 2020/6/21 19:10
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        char[] cs = String.valueOf(x).toCharArray();
        int start = 0, end = cs.length - 1;
        while (start < end) {
            if (cs[start++] != cs[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(123));
    }
}

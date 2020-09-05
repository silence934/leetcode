package xyz.nyist.leetcode.to200;

/**
 * @Author: silence
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * @Date:Create：in 2020/7/5 16:03
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] h = new boolean[128];
        int start = 0, end = 0, max = 0;
        while (end < s.length()) {
            if (!h[s.charAt(end)]) {
                h[s.charAt(end++)] = true;
                max = Math.max(max, end - start);
            }
            else {
                do {
                    h[s.charAt(start)] = false;
                } while (s.charAt(end) != s.charAt(start++));
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("pwwkew"));
    }

}

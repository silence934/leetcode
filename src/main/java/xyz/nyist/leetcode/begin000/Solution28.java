package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/9/9 17:24
 * @Description: "sadbutsad"
 * "sad"
 */
public class Solution28 {

    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int[] need = new int[128];
        for (char c : needle.toCharArray()) {
            need[c]++;
        }

        char[] chars = haystack.toCharArray();
        int start = 0, end = 0;

        while (end < chars.length) {
            if (end - start == needle.length()) {
                if (!needle.equals(haystack.substring(start, end))) {
                    need[chars[start]]++;
                    start++;
                } else {
                    return start;
                }
            }

            if (need[chars[end]] > 0) {
                need[chars[end]]--;
                end++;
            } else {
                while (chars[start] != chars[end]) {
                    need[chars[start]]++;
                    start++;
                }
                if (start != end) {
                    need[chars[start]]++;
                    start++;
                } else {
                    start++;
                    end++;
                }
            }
        }

        if (end - start == needle.length() && needle.equals(haystack.substring(start, end))) {
            return start;
        }

        return -1;
    }

}

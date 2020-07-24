package xyz.nyist.leetcode;

/**
 * @Author: silence
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 * @Date:Create：in 2020/6/15 14:12
 */
public class Solution14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int k = 0;
        char t = ' ';
        while (true) {
            int i = 0;
            for (; i < strs.length; i++) {
                if ("".equals(strs[i])) {
                    return "";
                }
                if (k >= strs[i].length()) {
                    break;
                }
                if (i == 0) {
                    t = strs[i].charAt(k);
                }
                else {
                    if (t != strs[i].charAt(k)) {
                        break;
                    }
                }
            }
            if (i != strs.length) {
                if (k == 0) {
                    return "";
                }
                break;
            }
            k++;
        }
        return strs[0].substring(0, k);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abca", "abc"}));
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}

package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/11/11 21:39
 * @Description:
 */
public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int m = 0;
        int n = s.length() / 2;
        int i = 0;
        for (; i < n; i++) {
            if (list.contains(s.charAt(i))) {
                m++;
            }
        }
        int p = 0;
        for (; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                p++;
            }
        }


        return p == m;
    }
}

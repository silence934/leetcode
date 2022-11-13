package xyz.nyist.leetcode.begin600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/13 21:47
 * @Description:
 */
public class Solution791 {
    public String customSortString(String order, String s) {
        char[] chars = order.toCharArray();
        int[] map = new int[128];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]] = i;
        }

        Character[] array = new Character[s.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.charAt(i);
        }
        Arrays.sort(array, (o1, o2) -> {
            if (o1 == o2) {
                return 0;
            } else {
                return map[o1] - map[o2];
            }
        });

        char[] ans = new char[s.length()];
        for (int i = 0; i < array.length; i++) {
            ans[i] = array[i];
        }

        return new String(ans);
    }
}
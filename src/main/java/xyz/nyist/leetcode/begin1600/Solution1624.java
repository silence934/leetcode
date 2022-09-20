package xyz.nyist.leetcode.begin1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/9/17 19:56
 * @Description:
 */
public class Solution1624 {

    public int maxLengthBetweenEqualCharacters(String s) {

        Map<Character, List<Integer>> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            List<Integer> l = map.get(aChar);
            if (l == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(aChar, list);
            } else {
                l.add(i);
            }
        }


        int ans = -1;

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            List<Integer> l = map.get(aChar);
            if (l != null) {
                ans = Math.max(ans, l.get(l.size() - 1) - i);
            }
        }


        return ans;
    }

}

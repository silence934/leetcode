package xyz.nyist.leetcode.begin400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/9/12 20:13
 * @Description:
 */
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] map = new int[128];


        for (char c : p.toCharArray()) {
            map[c]++;
        }

        int length = p.length();

        int left = 0, right = 0;
        char[] chars = s.toCharArray();

        while (right < chars.length) {
            if (map[chars[right]] > 0) {
                map[chars[right]]--;
                length--;
                right++;
                if (length == 0) {
                    res.add(left);
                    length++;
                    map[chars[left]]++;
                    left++;
                }
            } else {
                length++;
                map[chars[left]]++;
                left++;
            }
        }

        return res;
    }

}

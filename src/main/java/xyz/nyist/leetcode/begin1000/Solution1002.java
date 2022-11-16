package xyz.nyist.leetcode.begin1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/11/16 21:29
 * @Description:
 */
public class Solution1002 {
    public List<String> commonChars(String[] words) {
        int[][] map = new int[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                map[i][c - 'a']++;
            }
        }
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < words.length; j++) {
                min = Math.min(min, map[j][i]);
            }
            for (int j = 0; j < min; j++) {
                ans.add("" + (char) (i + 'a'));
            }
        }

        return ans;
    }
}

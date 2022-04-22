package xyz.nyist.leetcode.begin200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fucong
 * @Date: 2022/4/20 11:16
 * @Description:
 */
public class Solution388 {

    public int lengthLongestPath(String input) {
        String[] split = input.split("\n");

        int max = 0;


        Map<Integer, Integer> deep = new HashMap<>();
        deep.put(-1, 0);

        for (String str : split) {
            int level = count(str);
            deep.put(level, deep.get(level - 1) + str.length() - level * 2);
            if (str.contains(".")) {
                max = Math.max(max, deep.get(level) + level);
            }
        }


        return max;
    }


    private int count(String str) {
        return (str.length() - str.replaceAll("\t", "").length()) / 2;
    }

}

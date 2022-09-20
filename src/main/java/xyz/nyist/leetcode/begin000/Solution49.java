package xyz.nyist.leetcode.begin000;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
        for (String str : strs) {
            int[] map = new int[26];
            for (char c : str.toCharArray()) {
                map[c - 'a']++;
            }
            String key = Arrays.toString(map);
            List<String> list = listMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            listMap.put(key, list);
        }

        return new ArrayList<>(listMap.values());
    }

}

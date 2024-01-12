package xyz.nyist.leetcode.begin2000;

import java.util.HashMap;
import java.util.Map;

public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : words1) {
            map1.compute(s, (k, oldV) -> {
                if (oldV == null) {
                    return 1;
                }
                return oldV + 1;
            });
        }

        for (String s : words2) {
            map2.compute(s, (k, oldV) -> {
                if (oldV == null) {
                    return 1;
                }
                return oldV + 1;
            });
        }


        int res = 0;


        for (String key : map1.keySet()) {
            if (map1.get(key) == 1 && map2.containsKey(key) && map2.get(key) == 1) {
                res++;
            }
        }


        return res;
    }
}

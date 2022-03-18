package xyz.nyist.leetcode.begin600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: fucong
 * @Date: 2022/3/17 17:44
 * @Description:
 */
public class Solution720 {

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });

        Map<String, Object> map = new HashMap<>();
        map.put("", null);


        String res = "";

        for (String word : words) {
            if (map.containsKey(word.substring(0, word.length() - 1))) {
                map.put(word, null);
                if (word.length() > res.length()) {
                    res = word;
                }
            }
        }


        return res;
    }

}

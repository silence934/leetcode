package xyz.nyist.leetcode.begin800;

import java.util.*;

/**
 * @author: fucong
 * @Date: 2022/4/17 20:52
 * @Description:
 */
public class Solution819 {


    public static void main(String[] args) {
        Solution819 solution819 = new Solution819();
        System.out.println(solution819.mostCommonWord("Bob. hIt, baLl"
                , new String[]{"bob", "hit"}));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("!", " ")
                .replaceAll("\\?", " ")
                .replaceAll("'", " ")
                .replaceAll(",", " ")
                .replaceAll(";", " ")
                .replaceAll("\\.", " ")
                .toLowerCase();


        Map<String, Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>(Arrays.asList(banned));


        for (String str : paragraph.split(" ")) {
            if (!set.contains(str) && !Objects.equals(str, "")) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }


        int max = 0;

        String res = null;

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                res = item.getKey();
            }
        }

        return res;
    }

}

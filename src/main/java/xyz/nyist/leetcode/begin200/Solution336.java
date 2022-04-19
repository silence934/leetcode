package xyz.nyist.leetcode.begin200;

import java.util.*;

/**
 * @author: fucong
 * @Date: 2022/4/18 18:12
 * @Description: "abcd","dcba","lls","s","sssll"
 */
public class Solution336 {

    public static void main(String[] args) {
        Solution336 solution336 = new Solution336();
        System.out.println(solution336.palindromePairs(new String[]{"a", ""}));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }

        Set<List<Integer>> ans = new HashSet<>();

        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            for (int i = 0; i <= word.length(); i++) {
                if (isPairs(word, 0, i)) {
                    StringBuilder str = new StringBuilder(word.substring(i)).reverse();
                    List<Integer> list = map.get(str.toString());
                    if (list != null) {
                        for (Integer integer : list) {
                            if (integer != j) {
                                ans.add(Arrays.asList(integer, j));
                            }
                        }
                    }
                }
                if (isPairs(word, i, word.length())) {
                    StringBuilder str = new StringBuilder(word.substring(0, i)).reverse();
                    List<Integer> list = map.get(str.toString());
                    if (list != null) {
                        for (Integer integer : list) {
                            if (integer != j) {
                                ans.add(Arrays.asList(j, integer));
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }


    /**
     * 左闭右开
     */
    private boolean isPairs(String word, int start, int end) {
        end--;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

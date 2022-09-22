package xyz.nyist.leetcode.begin800;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/9/21 20:13
 * @Description:
 */
public class Solution854 {

    public static void main(String[] args) {
        System.out.println(new Solution854().kSimilarity("baababbaaabbabaaabaa",
                                                         "abaabaabababaabababa"));
    }


    int min;

    int ans;

    public int kSimilarity(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        min = 0;

        Map<Character, Set<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            Set<Integer> list = map2.getOrDefault(chars2[i], new HashSet<>());
            list.add(i);
            map2.put(chars2[i], list);
            if (chars1[i] != chars2[i]) {
                min++;
            }
        }

        min = min / 2 + min % 2;
        ans = chars1.length - 1;


        return find(chars1, chars2, 0, 0, map2);
    }


    private int find(char[] chars1, char[] chars2, int index, int operations, Map<Character, Set<Integer>> map2) {

        if (operations > ans) {
            return Integer.MAX_VALUE;
        }

        if (index == chars1.length) {
            ans = operations;
            return operations;
        }

        if (chars1[index] == chars2[index]) {
            return find(chars1, chars2, index + 1, operations, map2);
        }

        if (operations + getMin(chars1, chars2, index) > min + 5) {
            return Integer.MAX_VALUE;
        }

        Set<Integer> list = map2.get(chars1[index]);

        int ans = Integer.MAX_VALUE;


        for (Integer t : new ArrayList<>(list)) {
            if (t > index) {
                swap(chars2, index, t, map2);
                ans = Math.min(ans, find(chars1, chars2, index + 1, operations + 1, map2));
                swap(chars2, index, t, map2);
            }
        }

        return ans;
    }


    private int getMin(char[] chars1, char[] chars2, int index) {
        int ans = 0;
        for (int i = index; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                ans++;
            }
        }
        return (ans + 1) >> 1;
    }


    private void swap(char[] chars, int x, int y, Map<Character, Set<Integer>> map) {
        Set<Integer> set = map.get(chars[x]);
        set.remove(x);
        set.add(y);
        set = map.get(chars[y]);
        set.remove(y);
        set.add(x);

        char p = chars[x];
        chars[x] = chars[y];
        chars[y] = p;


    }

}

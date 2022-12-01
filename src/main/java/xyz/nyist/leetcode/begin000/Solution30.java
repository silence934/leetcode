package xyz.nyist.leetcode.begin000;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: silence
 * @Date: 2022/11/30 19:43
 * @Description:
 */
public class Solution30 {

    public static void main(String[] args) {
        System.out.println(new Solution30().findSubstring1("wordgoodgoodgoodbestword",
                new String[]{"word", "good", "best", "good"}));
    }


    public List<Integer> findSubstring(String s, String[] words) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Set<Integer> set = new HashSet<>();
            int index = 0;
            while ((index = s.indexOf(words[i], index)) != -1) {
                set.add(index);
                index = index + 1;
            }
            map.put(i, set);
        }


        int n = words[0].length();
        int target = (1 << words.length) - 1;

        byte[] bytes = new byte[words.length];
        List<Integer> ans = new ArrayList<>();
        for (Set<Integer> set : map.values()) {
            for (Integer index : set) {
                Arrays.fill(bytes, (byte) 0);
                for (int i = 0; i < words.length; i++) {
                    for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                        if (bytes[entry.getKey()] == 1) {
                            continue;
                        }
                        if (entry.getValue().contains(index + i * n)) {
                            bytes[entry.getKey()] = 1;
                            break;
                        }
                    }
                }
                int i = 0;
                for (; i < words.length; i++) {
                    if (bytes[i] == 0) {
                        break;
                    }
                }
                if (i == words.length) {
                    ans.add(index);
                }
            }
        }

        return ans.stream().distinct().collect(Collectors.toList());
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int n = words[0].length();
        int ls = s.length();


        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            int l = i, r = i;
            int m = words.length;

            while (r + n <= ls) {
                String rstr = s.substring(r, r + n);
                if (map.getOrDefault(rstr, 0) > 0) {
                    r = r + n;
                    map.put(rstr, map.get(rstr) - 1);
                    m--;
                    if (m == 0) {
                        ans.add(l);

                        String lstr = s.substring(l, l + n);
                        l = l + n;
                        m++;
                        map.put(lstr, map.getOrDefault(lstr, 0) + 1);
                    }
                } else {
                    String lstr = s.substring(l, l + n);
                    l = l + n;
                    m++;
                    map.put(lstr, map.getOrDefault(lstr, 0) + 1);
                }
            }

        }


        return ans;
    }
}

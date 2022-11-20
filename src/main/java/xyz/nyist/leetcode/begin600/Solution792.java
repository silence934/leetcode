package xyz.nyist.leetcode.begin600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/11/17 21:32
 * @Description:
 */
public class Solution792 {
    public static void main(String[] args) {
        System.out.println(new Solution792().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] map = new List[26];
        for (int i = 0; i < 26; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'].add(i);
        }

        int ans = 0;

        for (String word : words) {
            int p = 0;
            int i = 0;
            for (; i < word.length(); i++) {
                char c = word.charAt(i);
                int target = find(map[c - 'a'], p);
                if (target == -1) {
                    break;
                }
                p = target + 1;
            }
            if (i == word.length()) {
                ans++;
            }
        }

        return ans;
    }

    private int find(List<Integer> list, int index) {
        if (list.isEmpty() || list.get(list.size() - 1) < index) {
            return -1;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int t = list.get(mid);
            if (t == index) {
                return t;
            } else if (t > index) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return list.get(l);
    }

}

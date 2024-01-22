package xyz.nyist.leetcode.begin2000;

import java.util.HashSet;

public class Solution2103 {
    public int countPoints(String rings) {
        HashSet<Character>[] sets = new HashSet[10];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }

        for (int i = 0; i < rings.length(); i++) {
            sets[rings.charAt(i + 1) - '0'].add(rings.charAt(i));
            i++;
        }

        int res = 0;
        for (HashSet<Character> set : sets) {
            if (set.size() == 3) {
                res++;
            }
        }

        return res;
    }
}

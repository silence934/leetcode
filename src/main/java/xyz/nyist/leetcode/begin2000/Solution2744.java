package xyz.nyist.leetcode.begin2000;

import java.util.HashSet;
import java.util.Set;

public class Solution2744 {
    //["cd","ac","dc","ca","zz"]
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (word.equals(reverse)) {
                continue;
            }
            set.add(reverse);
        }
        int res = 0;
        for (String word : words) {
            if (set.contains(word)) {
                res++;
            }
        }
        return res / 2;
    }
}

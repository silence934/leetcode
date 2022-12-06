package xyz.nyist.leetcode.begin1800;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/12/6 21:14
 * @Description:
 */
public class Solution1805 {
    public int numDifferentIntegers(String word) {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                int t = i + 1;
                while (t < word.length() && Character.isDigit(word.charAt(t))) {
                    t++;
                }
                while (i < t && word.charAt(i) == '0') {
                    i++;
                }
                set.add(word.substring(i, t));
                i = t;
            }
        }

        return set.size();
    }
}

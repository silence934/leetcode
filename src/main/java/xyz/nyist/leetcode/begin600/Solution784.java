package xyz.nyist.leetcode.begin600;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/10/30 19:22
 * @Description:
 */
public class Solution784 {

    public List<String> letterCasePermutation(String s) {
        Set<String> ans = new HashSet<>();

        char[] chars = s.toCharArray();


        letterCasePermutation(chars, ans, 0);
        return new ArrayList<>(ans);
    }


    private void letterCasePermutation(char[] chars, Set<String> ans, int t) {
        if (t == chars.length) {
            ans.add(new String(chars));
        }
        for (int i = t; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                letterCasePermutation(chars, ans, i + 1);
                if (Character.isLowerCase(chars[i])) {
                    chars[i] = Character.toUpperCase(chars[i]);
                } else {
                    chars[i] = Character.toLowerCase(chars[i]);
                }

                letterCasePermutation(chars, ans, i + 1);
                if (Character.isLowerCase(chars[i])) {
                    chars[i] = Character.toUpperCase(chars[i]);
                } else {
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            } else {
                if (i == chars.length - 1) {
                    ans.add(new String(chars));
                }
            }
        }

    }

}

package xyz.nyist.leetcode.begin000;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/3/15 15:22
 * @Description:
 */
public class Solution20 {

    public boolean isValid(String s) {

        LinkedList<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                list.addLast(c);
            } else {
                if (list.size() == 0) {
                    return false;
                }
                Character character = list.removeLast();
                if (c == ')') {
                    if (character != '(') {
                        return false;
                    }
                } else if (c == '}') {
                    if (character != '{') {
                        return false;
                    }
                } else if (c == ']') {
                    if (character != '[') {
                        return false;
                    }
                }
            }
        }
        return list.size() == 0;
    }

}

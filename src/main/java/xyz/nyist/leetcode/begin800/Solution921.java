package xyz.nyist.leetcode.begin800;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/11/1 16:19
 * @Description:
 */
public class Solution921 {

    public int minAddToMakeValid(String s) {

        LinkedList<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (list.isEmpty()) {
                list.addLast(c);
            } else {
                if (c == ')' && list.getLast() == '(') {
                    list.removeLast();
                } else {
                    list.addLast(c);
                }
            }
        }


        return list.size();
    }

}

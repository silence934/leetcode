package xyz.nyist.leetcode.begin800;

/**
 * @author: silence
 * @Date: 2022/10/27 20:19
 * @Description:
 */
public class Solution856 {

    public int scoreOfParentheses(String s) {
        return scoreOfParentheses(s, 0, s.length());
    }


    public int scoreOfParentheses(String s, int start, int end) {

        int t = find(start, s);
        if (t == end - 1) {
            if (start + 1 == t) {
                return 1;
            } else {
                return 2 * scoreOfParentheses(s, start + 1, t);
            }
        } else {
            if (start + 1 == t) {
                return 1 + scoreOfParentheses(s, t + 1, end);
            } else {
                return 2 * scoreOfParentheses(s, start + 1, t) + scoreOfParentheses(s, t + 1, end);
            }
        }
    }


    private int find(int i, String s) {
        int t = 0;
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                t++;
            } else {
                if (t == 0) {
                    return j;
                }
                t--;
            }
        }
        return -1;
    }

}

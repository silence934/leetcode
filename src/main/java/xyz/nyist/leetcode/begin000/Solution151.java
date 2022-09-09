package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/8/17 19:26
 * @Description:
 */
public class Solution151 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        for (int i = s.length() - 1; i > -1; ) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int t = i;
            while (i > -1 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, t + 1);
            if (i != -1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}

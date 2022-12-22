package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/12/19 14:31
 * @Description:
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        while (s.charAt(i) == ' ') {
            i--;
        }

        int t = i - 1;

        while (t > -1 && s.charAt(t) != ' ') {
            t--;
        }


        return i - t;
    }
}

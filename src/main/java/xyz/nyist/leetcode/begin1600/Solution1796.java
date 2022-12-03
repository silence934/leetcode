package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/3 19:28
 * @Description:
 */
public class Solution1796 {
    public int secondHighest(String s) {

        char max = '0' - 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (c > max) {
                    max = c;
                }
            }
        }

        char max2 = '0' - 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (c > max2 && c < max) {
                    max2 = c;
                }
            }
        }

        return max2 >= '0' ? max2 - '0' : -1;

    }
}

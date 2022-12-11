package xyz.nyist.leetcode.begin1800;

/**
 * @author: silence
 * @Date: 2022/12/8 12:18
 * @Description:
 */
public class Solution1812 {
    public boolean squareIsWhite(String coordinates) {
        int m = coordinates.charAt(0) - 'a' + 1;
        int n = coordinates.charAt(0) - '0';

        return !(((m & 1) == 1 && (n & 1) == 1) ||
                ((m & 1) == 0 && (n & 1) == 0));
    }
}

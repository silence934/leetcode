package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2021/7/20 18:44
 * @Description:
 */
public class Solution6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int t = i;
            boolean b = false;

            int pre = -1;

            while (t < s.length()) {
                if (pre != t) {
                    sb.append(s.charAt(t));
                }

                pre = t;
                if (b) {
                    t = t + 2 * i;
                    b = false;
                } else {
                    t = t + 2 * (numRows - 1) - i * 2;
                    b = true;
                }
            }

        }
        return sb.toString();
    }

}

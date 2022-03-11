package xyz.nyist.leetcode.begin600;

/**
 * @author: fucong
 * @Date: 2021/9/27 16:15
 * @Description:
 */
public class Solution639 {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        long[] map = new long[s.length()];
        map[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = s.charAt(i - 1);
            if (c == '0') {
                if (c1 == '*') {
                    map[i] = map[i - 2] * 2;
                } else if (c1 == '1' || c1 == '2') {
                    map[i] = map[i - 2];
                } else {
                    map[i] = 0;
                }
            }
        }


        return (int) (map[map.length - 1] % (7 + (int) Math.pow(10, 9)));
    }

}

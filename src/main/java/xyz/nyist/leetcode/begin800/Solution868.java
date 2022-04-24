package xyz.nyist.leetcode.begin800;

/**
 * @author: fucong
 * @Date: 2022/4/24 13:59
 * @Description:
 */
public class Solution868 {

    public int binaryGap(int n) {
        int ans = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int p1 = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                if (p1 != -1) {
                    ans = Math.max(ans, i - p1);
                }
                p1 = i;
            }
        }

        return ans;
    }

}

package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/2 12:50
 * @Description:
 */
public class Solution1769 {
    public int[] minOperations(String boxes) {
        int lnumber = 0, rnumber = 0;
        char[] chars = boxes.toCharArray();

        int[] ans = new int[boxes.length()];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1') {
                rnumber++;
                ans[0] += i;
            }
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '1') {
                lnumber++;
            }
            ans[i] += (ans[i - 1] + lnumber - rnumber);
            if (chars[i] == '1') {
                rnumber--;
            }
        }

        return ans;
    }
}

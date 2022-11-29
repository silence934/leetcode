package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/29 14:13
 * @Description:
 */
public class Solution1758 {
    public int minOperations(String s) {
        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i & 1) == 1) {
                if (s.charAt(i) == '1') {
                    ans1++;
                } else {
                    ans2++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    ans2++;
                } else {
                    ans1++;
                }
            }

        }


        return Math.min(ans1, ans2);
    }
}

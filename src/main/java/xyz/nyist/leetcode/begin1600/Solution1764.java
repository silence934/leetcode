package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/12/17 17:09
 * @Description:
 */
public class Solution1764 {
    public boolean canChoose(int[][] groups, int[] nums) {

        String str = Arrays.toString(nums);
        str = str.substring(1, str.length() - 1);

        int t = 0;
        for (int[] group : groups) {
            String s = Arrays.toString(group);
            s = s.substring(1, s.length() - 1);

            int i = str.indexOf(s, t);
            while (i > 0 && str.charAt(i - 1) != ',') {
                i = str.indexOf(s, i + 1);
            }
            if (i < 0) {
                return false;
            }
            t = i + s.length() + 1;

        }


        return true;
    }
}

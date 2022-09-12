package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/9/12 20:45
 * @Description:
 */
public class Solution1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int t = nums.length - i;

            if (t <= nums[i] && (i == 0 || t > nums[i - 1])) {
                return t;
            }

        }
        return -1;
    }

}

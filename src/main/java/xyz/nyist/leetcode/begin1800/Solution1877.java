package xyz.nyist.leetcode.begin1800;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2021/7/20 15:14
 * @Description:
 */
public class Solution1877 {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }

        return max;
    }

}

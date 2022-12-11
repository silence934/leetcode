package xyz.nyist.leetcode.begin1800;

/**
 * @author: silence
 * @Date: 2022/12/11 20:16
 * @Description:
 */
public class Solution1827 {
    public int minOperations(int[] nums) {
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += (nums[i - 1] + 1 - nums[i]);
                nums[i] = nums[i - 1] + 1;
            }
        }

        return ans;
    }
}

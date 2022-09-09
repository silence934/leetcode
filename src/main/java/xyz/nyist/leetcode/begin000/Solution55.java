package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/7/6 19:32
 * @Description:
 */
public class Solution55 {

    Boolean[] memo;

    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int p) {
        if (p >= nums.length - 1) {
            return true;
        }
        if (memo[p] != null) {
            return memo[p];
        }
        for (int i = p + 1; i <= p + nums[p]; i++) {
            if (canJump(nums, i)) {
                memo[p] = true;
                break;
            }
        }
        if (memo[p] == null) {
            memo[p] = false;
        }
        return memo[p];
    }
}

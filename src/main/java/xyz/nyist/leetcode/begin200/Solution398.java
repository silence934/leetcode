package xyz.nyist.leetcode.begin200;

import java.util.Random;

/**
 * @author: fucong
 * @Date: 2022/4/25 13:38
 * @Description:
 */
public class Solution398 {

    private int[] nums;

    private Random random;

    public Solution398(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {

        int ans = 0;

        for (int i = 0, t = 1; i < nums.length; i++) {
            if (nums[i] == target && random.nextInt(t++) == 0) {
                ans = i;
            }
        }

        return ans;
    }

}

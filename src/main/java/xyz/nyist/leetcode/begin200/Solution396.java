package xyz.nyist.leetcode.begin200;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/4/22 18:38
 * @Description:
 */
public class Solution396 {

    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

}

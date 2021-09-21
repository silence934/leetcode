package xyz.nyist.leetcode.begin600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2021/8/5 18:34
 * @Description:
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            int p = i + 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (p < nums.length && nums[i] + nums[j] > nums[p]) {
                    p++;
                }

                res += Math.max(0, p - j - 1);

            }

        }

        return res;
    }
}

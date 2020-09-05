package xyz.nyist.leetcode.to200;

import java.util.Arrays;

/**
 * @Author: silence
 * @Description: 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * @Date:Create：in 2020/6/27 9:38
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (i > 0) {
                    if (nums[i] != nums[i - 1] && nums[i] == k) {
                        k++;
                    }
                }
                else if (nums[i] == k) {
                    k++;
                }
                else {
                    return k;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        System.out.println(solution41.firstMissingPositive(new int[]{1}));
    }
}

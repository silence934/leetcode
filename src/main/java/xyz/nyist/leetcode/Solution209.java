package xyz.nyist.leetcode;

/**
 * @Author: silence
 * @Description: 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * @Date:Create：in 2020/6/28 15:34
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0, min = nums.length + 1, sum = nums[0];
        while (true) {
            if (sum <= s) {
                if (end + 1 == nums.length) {
                    break;
                }
                sum += nums[++end];
            }
            else {
                if (start == end) {
                    return 1;
                }
                sum -= nums[start++];
                if (sum <= s) {
                    min = Math.min(min, end - start + 2);
                }
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();

        System.out.println(solution209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}

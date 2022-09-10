package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/10 21:35
 * @Description:
 */
public class Offer8 {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0, right = 0;

        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum >= target && left < right) {
                min = Math.min(right - left, min);
                sum -= nums[left];
                left++;
            } else {
                sum += nums[right];
                right++;
            }
        }

        while (left < right && sum >= target) {
            min = Math.min(right - left, min);
            sum -= nums[left];
            left++;
        }


        return min == Integer.MAX_VALUE ? 0 : min;
    }

}

package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/10 22:04
 * @Description:
 */
public class Offer9 {

    public static void main(String[] args) {
        System.out.println(new Offer9().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int ans = 0;

        int product = 1;

        int left = 0, right = 0;

        while (right < nums.length) {
            product *= nums[right];
            right++;
            if (product >= k) {
                while (left < right && product >= k) {
                    product /= nums[left];
                    left++;
                }
            }
            ans += right - left;
        }


        return ans;
    }

}

package xyz.nyist.leetcode.begin600;

/**
 * @author: fucong
 * @Date: 2022/5/5 10:31
 * @Description:
 */
public class Solution713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        if (k < 2) {
            return ans;
        }

        int slow = 0, fast = 0;


        int p = 1;
        while (fast < nums.length) {

            p = p * nums[fast];

            while (slow <= fast && p >= k) {
                p = p / nums[slow];
                slow++;
            }

            ans += fast - slow + 1;

            fast++;
        }


        return ans;
    }

}

package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/11/24 15:25
 * @Description:
 */
public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                int t = i + 1;
                while (t < nums.length && nums[t] <= right) {
                    t++;
                }
                for (int j = i; j < t; j++) {
                    if (nums[j] >= left && nums[j] <= right) {
                        int k = j - 1;
                        while (k >= 0 && nums[k] < left) {
                            k--;
                        }
                        ans += ((j - k) * (t - j));
                    }
                }
                i = t - 1;
            }
        }

        return ans;
    }
}

package xyz.nyist.leetcode.begin2000;

public class Solution2765 {
    public static void main(String[] args) {
        System.out.println(new Solution2765().alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }

    public int alternatingSubarray(int[] nums) {

        int ans = -1;

        for (int i = 0; i < nums.length; ) {
            int t = i + 1;
            while (t < nums.length && ((t - i - 1) % 2 == 0 ? nums[t] - nums[t - 1] == 1 : nums[t] - nums[t - 1] == -1)) {
                t++;
            }
            if (t > i + 1) {
                ans = Math.max(ans, t - i);
                i = t - 1;
            } else {
                i = t;
            }

        }

        return ans;
    }
}

package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: silence
 * @Date: 2021/7/5 10:25
 * @Description:
 */
public class Solution300 {

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

    public int lengthOfLISV2(int[] nums) {

        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }


    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid) >= nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                list.set(l, nums[i]);
            }
        }

        return list.size();
    }
}

package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/20 15:40
 * @Description:
 */
public class Solution1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }

        int ans = 0;
        int l = 1, r = max;


        while (l <= r) {
            int mid = l + (r - l) / 2;

            int ops = 0;
            for (int x : nums) {
                ops += ((x - 1) / mid);
            }

            if (ops <= maxOperations) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}

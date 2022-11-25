package xyz.nyist.leetcode.begin1400;

import java.util.LinkedList;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/23 17:24
 * @Description:
 */
public class Solution1425 {

    public static void main(String[] args) {
        System.out.println(new Solution1425().constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.getFirst() < i - k) {
                queue.removeFirst();
            }

            dp[i] = Math.max((queue.isEmpty() ? 0 : dp[queue.getFirst()]), 0) + nums[i];
            while (!queue.isEmpty() && dp[queue.getLast()] < dp[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private int constrainedSubsetSum(int[] nums, int k, int index, int sum, Map<Integer, Integer> cache) {
        if (cache.containsKey(index) && cache.get(index) > sum) {
            return Integer.MIN_VALUE;
        }
        cache.put(index, sum);
        int ans = sum;

        for (int i = index; i < nums.length; i++) {
            if (i - index < k) {
                ans = Math.max(ans, constrainedSubsetSum(nums, k, i + 1, sum + nums[i], cache));
            } else {
                ans = Math.max(ans, constrainedSubsetSum(nums, k, i + 1, 0, cache));
            }
        }

        return ans;
    }

}

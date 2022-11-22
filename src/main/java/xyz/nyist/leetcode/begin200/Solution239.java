package xyz.nyist.leetcode.begin200;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/11/21 20:31
 * @Description:
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        int t = 0;
        for (int i = k; i < nums.length; i++) {
            ans[t++] = nums[queue.getFirst()];
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i - k >= queue.getFirst()) {
                queue.removeFirst();
            }
        }
        ans[t] = nums[queue.getFirst()];

        return ans;
    }
}

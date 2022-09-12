package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/9/11 20:10
 * @Description:
 */
public class Solution724 {

    public int pivotIndex(int[] nums) {

        int[] pre = new int[nums.length + 1];

        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }


        int t = pre[pre.length - 1];

        for (int i = 0; i < nums.length; i++) {
            if (pre[i] == t - pre[i + 1]) {
                return i;
            }
        }

        return -1;
    }

}

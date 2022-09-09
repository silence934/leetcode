package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/7/7 11:44
 * @Description:
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = height.length - 2; i > -1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }


        return res;
    }
}

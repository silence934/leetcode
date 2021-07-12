package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2021/7/12 19:05
 * @Description:
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int max = 0;

        int left = 0, right = height.length - 1;

        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

}

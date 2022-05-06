package xyz.nyist.leetcode.begin1000;

/**
 * @author: fucong
 * @Date: 2022/5/6 10:38
 * @Description:
 */
public class Solution1004 {

    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0;
        int ans = 0;

        while (left < nums.length && right < nums.length) {

            while (right < nums.length) {
                if (nums[right] == 0) {
                    if (k == 0) {
                        break;
                    }
                    k--;
                }
                right++;
            }

            ans = Math.max(ans, right - left);

            if (nums[left] == 0) {
                k++;
            }
            left++;

        }


        return ans;
    }

}

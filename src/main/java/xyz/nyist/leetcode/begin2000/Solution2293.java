package xyz.nyist.leetcode.begin2000;


/**
 * @author: silence
 * @Date: 2023/1/15 19:34
 * @Description:
 */
public class Solution2293 {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] newArr = new int[nums.length / 2];


        for (int i = 0; i < newArr.length; i++) {
            if ((i & 1) == 1) {
                newArr[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            } else {
                newArr[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }
        }

        return minMaxGame(newArr);
    }
}

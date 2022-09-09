package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/3/18 10:42
 * @Description:
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
                t++;
            }
        }

        int r = nums.length - 1;

        for (int i = 0; i < nums.length && i < r; i++) {
            if (nums[i] == -1) {
                while (i < r && nums[r] == -1) {
                    r--;
                }
                if (nums[r] != -1) {
                    nums[i] = nums[r];
                    nums[r] = -1;
                } else {
                    break;
                }
            }
        }


        return nums.length - t;
    }

}

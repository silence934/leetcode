package xyz.nyist.leetcode.begin200;

/**
 * @author: fucong
 * @Date: 2022/4/4 21:23
 * @Description: 线段树  树状数组
 */
public class Solution307 {


    private int[] nums;

    private int[] sums;

    public Solution307(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        this.nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return 0;
    }

}

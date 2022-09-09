package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/7/14 11:06
 * @Description:
 */
public class Solution31 {

    public static void main(String[] args) {
        new Solution31().nextPermutation(new int[]{1, 3, 2});
    }

    public void nextPermutation(int[] nums) {

        boolean flag = true;

        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] < nums[i + 1]) {
                flag = false;

                int k = i + 1;
                int min = nums[k];
                for (int j = k + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i] && nums[j] <= min) {
                        k = j;
                    }
                }

                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;

                nextPermutation(nums, i + 1, nums.length - 1);

                break;
            }
        }

        if (flag) {
            nextPermutation(nums, 0, nums.length - 1);
        }

    }

    private void nextPermutation(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }

}

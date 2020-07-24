package xyz.nyist.leetcode;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/10 22:42
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return search(nums, target, 0);
    }

    public int search(int[] nums, int target, int k) {
        int index = nums.length / 2;
        int t = nums[index];
        boolean isOrder = nums[0] <= t;
        if (nums[index] == target) {
            return index + k;
        }
        else if (nums.length < 2) {
            return -1;
        }
        else if (isOrder) {
            if (target < t && target >= nums[0]) {
                int[] te = new int[index];
                System.arraycopy(nums, 0, te, 0, index);
                return search(te, target, k);
            }
            else {
                int l = nums.length - index - 1;
                if (l < 1) {
                    return -1;
                }
                int[] te = new int[l];
                System.arraycopy(nums, index + 1, te, 0, l);
                return search(te, target, k + index + 1);
            }
        }
        else {
            if (target > t && target <= nums[nums.length - 1]) {
                int l = nums.length - index - 1;
                if (l < 1) {
                    return -1;
                }
                int[] te = new int[l];
                System.arraycopy(nums, index + 1, te, 0, l);
                return search(te, target, k + index + 1);
            }
            else {
                int[] te = new int[index];
                System.arraycopy(nums, 0, te, 0, index);
                return search(te, target, k);
            }
        }
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}

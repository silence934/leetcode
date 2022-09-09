package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/3/15 16:54
 * @Description:
 */
public class Solution26 {


    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        System.out.println(solution26.removeDuplicates(new int[]{1, 1}));
    }

    public int removeDuplicates(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i - 1];
            while (i < nums.length && nums[i] == t) {
                nums[i] = Integer.MAX_VALUE;
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                int next = findNext(nums, i + 1);
                if (next == Integer.MAX_VALUE) {
                    return i;
                }
                nums[i] = next;
            }
        }

        return nums.length;
    }


    private int findNext(int[] nums, int index) {
        int res = Integer.MAX_VALUE;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                res = nums[i];
                nums[i] = Integer.MAX_VALUE;
                break;
            }
        }
        return res;
    }

}

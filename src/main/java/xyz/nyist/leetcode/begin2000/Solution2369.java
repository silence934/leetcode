package xyz.nyist.leetcode.begin2000;

public class Solution2369 {

    public static void main(String[] args) {
        System.out.println(new Solution2369().validPartition(new int[]{4, 4, 4, 5, 6}));
    }

    public boolean validPartition(int[] nums) {
        return validPartition(nums, 0, new Boolean[nums.length]);
    }

    public boolean validPartition(int[] nums, int offset, Boolean[] res) {
        if (offset == nums.length) {
            return true;
        }

        if (res[offset] != null) {
            return res[offset];
        }

        boolean ans = false;


        if (offset + 1 < nums.length && nums[offset] == nums[offset + 1]) {
            ans = validPartition(nums, offset + 2, res);
            if (ans) {
                res[offset] = true;
                return true;
            }
        }
        if (offset + 2 < nums.length &&
                (
                        nums[offset] == nums[offset + 1] && nums[offset] == nums[offset + 2]
                                || nums[offset] + 1 == nums[offset + 1] && nums[offset] + 2 == nums[offset + 2]
                )) {
            ans = validPartition(nums, offset + 3, res);
        }

        res[offset] = ans;

        return ans;
    }

}

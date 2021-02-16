package xyz.nyist.leetcode.begin400;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fucong
 * @Date: 2020-09-20 17:13
 * @Description :
 */
public class Solution448 {
    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        System.out.println(solution448.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int t = Math.abs(num) - 1;
            nums[t] = -Math.abs(nums[t]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}

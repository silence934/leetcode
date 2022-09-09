package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/3/10 19:02
 * @Description:
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        System.out.println(solution78.subsets(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> subsets(int[] nums, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (index == nums.length - 1) {
            res.add(Collections.singletonList(nums[index]));
            res.add(Collections.emptyList());
            return res;
        }
        List<List<Integer>> subsets = subsets(nums, index + 1);
        for (List<Integer> subset : subsets) {
            ArrayList<Integer> list = new ArrayList<>(subset);
            list.add(nums[index]);
            res.add(list);
        }
        res.addAll(subsets);
        return res;
    }

}

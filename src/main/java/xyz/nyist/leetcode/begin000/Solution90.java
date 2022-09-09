package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/3/10 19:19
 * @Description:
 */
public class Solution90 {

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(nums, 0);
        return res;
    }


    private void subsets(int[] nums, int index) {

        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.addLast(nums[i]);
            subsets(nums, i + 1);
            list.removeLast();
        }
    }

}

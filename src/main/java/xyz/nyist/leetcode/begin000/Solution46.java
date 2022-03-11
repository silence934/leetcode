package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/3/11 14:25
 * @Description:
 */
public class Solution46 {

    private List<List<Integer>> res = new ArrayList<>();

    private LinkedList<Integer> list = new LinkedList<>();

    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permute1(nums);
        return res;
    }


    public void permute1(int[] nums) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.addLast(nums[i]);
            used[i] = true;
            permute1(nums);
            list.removeLast();
            used[i] = false;
        }

    }

}

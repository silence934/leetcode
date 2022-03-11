package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/3/11 16:01
 * @Description:
 */
public class Solution40 {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0);
        return res;
    }


    public void combinationSum2(int[] candidates, int target, int start) {

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.addLast(candidates[i]);
            sum += candidates[i];
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }

            combinationSum2(candidates, target, i + 1);

            Integer last = list.removeLast();
            sum -= last;
        }

    }

}

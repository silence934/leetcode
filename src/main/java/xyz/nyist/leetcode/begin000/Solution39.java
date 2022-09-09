package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: silence
 * @Date: 2021/7/14 13:17
 * @Description:
 */
public class Solution39 {

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {

        List<List<Integer>>[] dp = new ArrayList[target + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());

        for (int i = 1; i < target + 1; i++) {
            for (int candidate : candidates) {
                if (candidate <= i) {
                    for (List<Integer> list : dp[i - candidate]) {
                        List<Integer> temp = new ArrayList<>(list);
                        temp.add(candidate);
                        dp[i].add(temp);
                    }
                }
            }
            for (List<Integer> list : dp[i]) {
                Collections.sort(list);
            }
            dp[i] = dp[i].stream().distinct().collect(Collectors.toList());
        }

        return dp[target];
    }


    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0);
        return res;
    }


    public void combinationSum(int[] candidates, int target, int start) {

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            list.addLast(candidate);
            sum += candidate;

            if (sum == target) {
                res.add(new ArrayList<>(list));
            } else {
                combinationSum(candidates, target, i);
            }

            list.removeLast();
            sum -= candidate;
        }

    }


}

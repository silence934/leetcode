package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/3/11 16:09
 * @Description:
 */
public class Solution47 {

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.permuteUnique(new int[]{1, 2, 3}));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    boolean[] usd;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        usd = new boolean[nums.length];
        permuteUnique1(nums);
        return res;
    }

    public void permuteUnique1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (usd[i] || (i != 0 && !usd[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            list.addLast(nums[i]);
            usd[i] = true;

            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
            } else {
                permuteUnique1(nums);
            }

            list.removeLast();
            usd[i] = false;

        }

    }

}

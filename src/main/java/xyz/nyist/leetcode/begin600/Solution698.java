package xyz.nyist.leetcode.begin600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/9/20 18:30
 * @Description:
 */
public class Solution698 {


    public static void main(String[] args) {
        System.out.println(new Solution698().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    Set<String> set;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        sum = sum / k;

        //Arrays.sort(nums);

        set = new HashSet<>();
        return test(nums, new HashSet<>(), sum, 0);
    }

    private boolean test(int[] nums, Set<Integer> used, int target, int current) {
        ArrayList<Integer> list = new ArrayList<>(used);
        Collections.sort(list);
        if (set.contains(list.toString())) {
            return false;
        }

        if (target < current) {
            return false;
        }
        if (used.size() == nums.length && target != current) {
            return false;
        }
        if (current == target) {
            if (used.size() == nums.length) {
                return true;
            }
            return test(nums, used, target, 0);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return false;
            }
            if (!used.contains(i)) {
                current += nums[i];
                used.add(i);
                if (test(nums, used, target, current)) {
                    return true;
                }

                list = new ArrayList<>(used);
                Collections.sort(list);
                set.add(list.toString());

                used.remove(i);
                current -= nums[i];
            }
        }

        return false;
    }


}

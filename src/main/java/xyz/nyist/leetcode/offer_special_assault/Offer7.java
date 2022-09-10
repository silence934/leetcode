package xyz.nyist.leetcode.offer_special_assault;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/9/9 16:16
 * @Description: <a href="https://leetcode.cn/problems/1fGaJU/?plan=lcof&plan_progress=zqxc5y6">...</a>
 */
public class Offer7 {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> asn = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                int find = -nums[i] - nums[j];
                if (findTarget(nums, j + 1, nums.length, find)) {
                    asn.add(Arrays.asList(nums[i], nums[j], find));
                }
            }
        }

        return new ArrayList<>(asn);
    }


    private boolean findTarget(int[] nums, int start, int end, int target) {
        if (start >= end || nums[start] > target) {
            return false;
        }

        int mid = (end + start) / 2;

        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            return findTarget(nums, start, mid, target);
        } else {
            return findTarget(nums, mid + 1, end, target);
        }

    }

}

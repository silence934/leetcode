package xyz.nyist.leetcode.begin000;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/3/15 14:51
 * @Description:
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int t = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    Integer index = map.get(target - t - nums[k]);
                    if (index != null && index > k) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[index]));
                    }
                }
            }
        }

        return res;
    }

}

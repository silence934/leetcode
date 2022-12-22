package xyz.nyist.leetcode.begin1600;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/12/22 17:08
 * @Description:
 */
public class Solution1799 {


    Map<String, Integer> gocCache;

    int ans = 0;

    public int maxScore(int[] nums) {
        gocCache = new HashMap<>();
        maxScore(nums, new boolean[nums.length], 0, new ArrayList<>());
        return ans;
    }


    private void maxScore(int[] nums, boolean[] used, int index, List<Integer> gocs) {
        if (gocs.size() == nums.length / 2) {
            Collections.sort(gocs);
            int sum = 0;
            for (int i = 0; i < gocs.size(); i++) {
                sum += (i + 1) * gocs.get(i);
            }
            ans = Math.max(ans, sum);
        }


        int idx = index;
        while (used[idx])
            idx++;
        used[idx] = true;
        for (int i = idx + 1; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                gocs.add(goc(nums[idx], nums[i]));
                maxScore(nums, used, idx + 1, gocs);
                used[i] = false;
                gocs.remove(gocs.size() - 1);
            }
        }
        used[idx] = false;

//        for (int i = index; i < nums.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (!used[j]) {
//                        used[j] = true;
//                        gocs.add(goc(nums[i], nums[j]));
//                        maxScore(nums, used, index + 1, gocs);
//                        gocs.remove(gocs.size() - 1);
//                        used[j] = false;
//                    }
//                }
//                used[i] = false;
//            }
//        }

    }


    private int goc(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        String key = min + "," + max;

        if (gocCache.containsKey(key)) {
            return gocCache.get(key);
        }

        int ans;
        if (max % min == 0) {
            ans = min;
        } else {
            ans = goc(min, max % min);
        }

        gocCache.put(key, ans);
        return ans;
    }

}

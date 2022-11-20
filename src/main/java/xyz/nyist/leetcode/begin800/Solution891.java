package xyz.nyist.leetcode.begin800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/18 22:10
 * @Description:
 */
public class Solution891 {

    static int MOD = 1000000007;

    public int sumSubseqWidths(int[] nums) {
        return dfs(nums, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, new HashMap<>());
    }

    private int dfs(int[] nums, int index, Integer max, Integer min, Map<String, Integer> cache) {
        String key = index + "," + max + "," + min;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ans = 0;
        if (max >= min) {
            ans = ans + (max - min) % MOD;
        }

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            ans = (ans + dfs(nums, i + 1, Math.max(max, num), Math.min(min, num), cache) % MOD) % MOD;
        }
        cache.put(key, ans);
        return ans;
    }


    public int sumSubseqWidths1(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[j - 1]) {
                    continue;
                }
                ans = (ans + (nums[j] - nums[i]) * (1L << (j - i - 1)) % MOD) % MOD;
            }
        }

        System.out.println(ans);
        return (int) ans;
    }

}

package xyz.nyist.leetcode.begin1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/24 16:57
 * @Description:
 */
public class Solution1388 {


    public int maxSizeSlices1(int[] slices) {
        int[][] dp = new int[slices.length][slices.length / 3 + 1];

        for (int i = 0; i < slices.length - 1; i++) {
            for (int j = 1; j <= slices.length / 3; j++) {
                dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0, (i > 1 ? dp[i - 2][j - 1] : 0) + slices[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int ans = dp[slices.length - 2][slices.length / 3];

        dp = new int[slices.length][slices.length / 3 + 1];

        for (int i = 1; i < slices.length; i++) {
            for (int j = 1; j <= slices.length / 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], (i > 1 ? dp[i - 2][j - 1] : 0) + slices[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));

        ans = Math.max(ans, dp[slices.length - 1][slices.length / 3]);

        return ans;
    }

    public int maxSizeSlices(int[] slices) {
        return maxSizeSlices(new boolean[slices.length], slices, 0, new HashMap<>());
    }


    private int maxSizeSlices(boolean[] used, int[] slices, int ans, Map<String, Integer> cache) {
        String key = Arrays.toString(used);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int max = ans;
        for (int i = 0; i < slices.length; i++) {
            if (!used[i]) {
                used[i] = true;
                int next = i + 1;
                if (next == used.length) {
                    next = 0;
                }
                while (used[next]) {
                    next++;
                    if (next == used.length) {
                        next = 0;
                    }
                }
                int pre = i - 1;
                if (pre == -1) {
                    pre = used.length - 1;
                }
                while (used[pre]) {
                    pre--;
                    if (pre == -1) {
                        pre = used.length - 1;
                    }
                }
                used[next] = true;
                used[pre] = true;
                max = Math.max(maxSizeSlices(used, slices, ans + slices[i], cache), max);
                used[i] = false;
                used[next] = false;
                used[pre] = false;
            }
        }
        cache.put(key, max);
        return max;
    }


}

package xyz.nyist.leetcode.begin200;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/24 21:18
 * @Description:
 */
public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

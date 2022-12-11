package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: silence
 * @Date: 2022/12/11 19:32
 * @Description:
 */
public class Solution1691 {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, Comparator.comparingInt(o -> o[0] + o[1] + o[0]));

        int[] dp = new int[cuboids.length];

        int max = 0;

        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] &&
                        cuboids[i][1] >= cuboids[j][1] &&
                        cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

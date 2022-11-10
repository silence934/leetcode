package xyz.nyist.leetcode.begin600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/11/9 15:10
 * @Description:
 */
public class Solution764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {

        Set<String> set = new HashSet<>();
        for (int[] mine : mines) {
            set.add(mine[0] + "," + mine[1]);
        }

        int[][][] map = new int[n][n][4];


        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isZero(i, j, set)) {
                    Arrays.fill(map[i][j], 0);
                } else {

                    if (i == 0) {
                        map[i][j][0] = 0;
                    } else {
                        if (isZero(i - 1, j, set)) {
                            map[i][j][0] = 0;
                        } else {
                            map[i][j][0] = map[i - 1][j][0] + 1;
                        }
                    }

                    if (j == 0 || isZero(i, j - 1, set)) {
                        int t = j + 1;
                        while (t < n && !isZero(i, t, set)) {
                            t++;
                        }
                        map[i][j][1] = t - j - 1;
                    } else {
                        map[i][j][1] = Math.max(map[i][j - 1][1] - 1, 0);
                    }

                    if (i == 0 || isZero(i - 1, j, set)) {
                        int t = i + 1;
                        while (t < n && !isZero(t, j, set)) {
                            t++;
                        }
                        map[i][j][2] = t - i - 1;
                    } else {
                        map[i][j][2] = Math.max(map[i - 1][j][2] - 1, 0);
                    }


                    if (j == 0) {
                        map[i][j][3] = 0;
                    } else {
                        if (isZero(i, j - 1, set)) {
                            map[i][j][3] = 0;
                        } else {
                            map[i][j][3] = map[i][j - 1][3] + 1;
                        }
                    }

                    int min = map[i][j][0];
                    min = Math.min(min, map[i][j][1]);
                    min = Math.min(min, map[i][j][2]);
                    min = Math.min(min, map[i][j][3]);

                    ans = Math.max(ans, min + 1);

                }

                System.out.println(Arrays.toString(map[i][j]));

            }
        }


        return ans;
    }

    private boolean isZero(int x, int y, Set<String> set) {
        return set.contains(x + "," + y);
    }


}

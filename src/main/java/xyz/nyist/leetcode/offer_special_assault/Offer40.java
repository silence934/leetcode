package xyz.nyist.leetcode.offer_special_assault;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer40 {

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length();


        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            String str = matrix[i];
            for (int j = 0; j < n; j++) {
                int start = j;
                while (j < n && str.charAt(j) == '1') {
                    j++;
                }
                for (int k = start; k < j; k++) {
                    map[i][k] = j - k;
                }
            }
        }

        int max = 0;


        System.out.println(Arrays.deepToString(map));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = i;
                int min = Integer.MAX_VALUE;
                while (t < m && map[t][j] > 0) {
                    min = Math.min(min, map[t][j]);
                    t++;
                }
                max = Math.max(max, (t - i) * min);
            }
        }

        return max;
    }

}

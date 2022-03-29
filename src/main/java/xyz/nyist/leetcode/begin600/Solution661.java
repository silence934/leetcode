package xyz.nyist.leetcode.begin600;

import java.util.Arrays;

/**
 * @author: fucong
 * @Date: 2022/3/24 19:06
 * @Description:
 */
public class Solution661 {

    public static void main(String[] args) {
        int[][] img = new int[][]{
                new int[]{100, 200, 100},
                new int[]{200, 50, 200},
                new int[]{100, 200, 100}
        };

        Solution661 solution661 = new Solution661();
        System.out.println(Arrays.deepToString(solution661.imageSmoother(img)));
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }
                ret[i][j] = sum / num;
            }
        }
        return ret;
    }

}

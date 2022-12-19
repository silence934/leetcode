package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/12/17 20:34
 * @Description:
 */
public class Solution48 {
    public void rotate(int[][] matrix) {

        for (int p = 0; p < matrix.length / 2; p++) {
            int m = matrix.length - 1 - 2 * p;
            for (int i = p; i < p + m; i++) {
                int t = matrix[p][i];
                matrix[p][i] = matrix[p + m - i + p][p];
                matrix[p + m - i + p][p] = matrix[p + m][p + m - i + p];
                matrix[p + m][p + m - i + p] = matrix[i][p + m];
                matrix[i][p + m] = t;
            }
        }

    }
}

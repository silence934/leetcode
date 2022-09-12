package xyz.nyist.leetcode.offer_special_assault;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/9/11 20:10
 * @Description:
 */
public class Offer13 {

    private int[][] matrix;

    public Offer13(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 1; j < this.matrix[0].length; j++) {
                this.matrix[i][j] = this.matrix[i][j - 1] + matrix[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(this.matrix));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            ans += matrix[i][col2] - matrix[i][col1];
        }
        return ans;
    }

}

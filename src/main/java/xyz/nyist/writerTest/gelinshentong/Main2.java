package xyz.nyist.writerTest.gelinshentong;

/**
 * @Author : fucong
 * @Date: 2020-11-08 13:56
 * @Description :
 */
public class Main2 {
    public static void main(String[] args) {

    }

    private static int getMaxPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                dp[i][0] = matrix[i][0];
            } else {
                dp[i][0] = dp[i - 1][0] + matrix[i][0];
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (i != 0) {
                dp[0][i] = dp[0][i - 1] + matrix[0][i];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }

}

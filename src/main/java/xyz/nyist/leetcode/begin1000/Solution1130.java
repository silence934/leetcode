package xyz.nyist.leetcode.begin1000;

/**
 * @author: silence
 * @Date: 2022/4/12 18:43
 * @Description: todo 未完成
 */
public class Solution1130 {

    public static void main(String[] args) {
        Solution1130 solution1130 = new Solution1130();
        System.out.println(solution1130.mctFromLeafValues(new int[]{15, 13, 5, 3, 15}));
    }

    public int mctFromLeafValues(int[] arr) {
        int[][][] dp = new int[arr.length][arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = arr[j];
                } else if (i == j + 1 || i == j - 1) {
                    dp[i][j][0] = arr[i] * arr[j];
                    dp[i][j][1] = Math.max(arr[i], arr[j]);
                } else {
                    int[] ints = dp[i - 1][j];
                }
            }
        }
        return dp[0][arr.length - 1][1];
        // return mctFromLeafValues(arr, arr.length - 1)[0];
    }


    /**
     * @param index 前index位（包含）
     * @return 第一个是结果  第二个是 根结点的值
     */
    public int[] mctFromLeafValues(int[] arr, int index) {
        if (index == 0) {
            return new int[]{0, arr[0]};
        } else if (index == 1) {
            return new int[]{arr[0] * arr[1], Math.max(arr[0], arr[1])};
        }

        int[] int1 = mctFromLeafValues(arr, index - 1);

        int i1 = Math.max(int1[1], arr[index]);
        int s1 = int1[0] + int1[1] * arr[index];


        int[] int2 = mctFromLeafValues(arr, index - 2);

        int i2 = Math.max(int2[1], Math.max(arr[index], arr[index - 1]));
        int s2 = int2[0] + arr[index] * arr[index - 1] + int1[1] * Math.max(arr[index], arr[index - 1]);

        if (s1 > s2) {
            return new int[]{s2, i2};
        }
        return new int[]{s1, i1};
    }

}

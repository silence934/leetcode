package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2021/7/26 14:19
 * @Description:
 */
public class Solution1713 {

    public static void main(String[] args) {
        System.out.println(new Solution1713().minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1}));
    }

    public int minOperations(int[] target, int[] arr) {
        int[][] dp1 = new int[arr.length + 1][2];

        for (int i = 1; i <= target.length; i++) {
            for (int j = 0; j <= arr.length; j++) {
                if (j == 0) {
                    dp1[j][i & 1] = i;
                } else {
                    if (target[i - 1] == arr[j - 1]) {
                        dp1[j][i & 1] = dp1[j - 1][(i - 1) & 1];
                    } else {
                        dp1[j][i & 1] = Math.min(dp1[j][(i - 1) & 1] + 1, dp1[j - 1][i & 1]);
                    }
                }
            }
        }

        return dp1[arr.length][target.length & 1];
    }

}

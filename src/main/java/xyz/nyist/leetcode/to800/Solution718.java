package xyz.nyist.leetcode.to800;

/**
 * @Author: silence
 * @Description: 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/1 19:08
 */
public class Solution718 {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length][B.length];
        for (int i = A.length - 1; i > -1; i--) {
            for (int j = B.length - 1; j > -1; j--) {
                if (A[i] != B[j]) {
                    dp[i][j] = 0;
                }
                else {
                    if (i == A.length - 1 || j == B.length - 1) {
                        dp[i][j] = 1;
                        max = Math.max(max, 1);
                    }
                    else {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();
        System.out.println(solution718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}

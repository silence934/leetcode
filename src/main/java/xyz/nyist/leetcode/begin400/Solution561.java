package xyz.nyist.leetcode.begin400;

import java.util.Arrays;

/**
 * @Author : fucong
 * @Date: 2021-02-16 19:41
 * @Description :
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 返回该 最大总和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-partition-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r += nums[i++];
        }
        return r;
    }

    public static void main(String[] args) {
        Solution561 solution561 = new Solution561();
        System.out.println(solution561.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }
}

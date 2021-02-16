package xyz.nyist.leetcode.begin000;

import java.util.Arrays;

/**
 * @Author: silence
 * @Description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/24 9:17
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        //Arrays.sort(nums);
        int r = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int h = nums[i] + nums[j] + nums[k], s;
                    if ((s = Math.abs(target - h)) < min) {
                        min = s;
                        r = h;
                    }
                }
            }
        }
        return r;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int r = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int h = nums[i] + nums[j] + nums[k], d = h - target, s;
                if (d == 0) {
                    return target;
                } else if ((s = Math.abs(d)) < min) {
                    min = s;
                    r = h;
                }
                if (d < 0) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return r;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution16 solution16 = new Solution16();
        System.out.println(solution16.threeSumClosest1(new int[]{0, 2, 1, -3}, 1));
        System.out.println(System.currentTimeMillis() - start);
    }
}

package xyz.nyist.leetcode.lcp;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2021/9/17 15:36
 * @Description:
 */
public class LCP28 {

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = 1;
        }

        System.out.println(new LCP28().purchasePlans(arr, 2));
    }

    public int purchasePlans(int[] nums, int target) {

        Arrays.sort(nums);

        long res = 0;

        int end = find(nums, target, 0, nums.length - 1);
//4999950000
        for (int i = 0; i < end - 1; i++) {
            if (target > nums[i]) {
                res += ((find(nums, target - nums[i], i + 1, end - 1) - i - 1));
            }
        }
//999949972
        return (int) (res % 1000000007);
    }

    /**
     * 大于target的最小值的位置
     *
     * @param nums   数组 已排序
     * @param target target
     * @param start  开始位置（包含）
     * @param end    结束为止（包含）
     */
    private int find(int[] nums, int target, int start, int end) {
        if (nums[start] > target) {
            return start;
        }
        if (nums[end] <= target) {
            return end + 1;
        }

        if (start + 1 == end) {
            return end;
        }


        int k = (start + end) / 2;

        if (nums[k] > target) {
            return find(nums, target, start, k);
        } else {
            return find(nums, target, k, end);
        }

    }


}

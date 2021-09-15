package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2021/9/15 15:12
 * @Description:
 */
public class Solution162 {

    public int findPeakElement(int[] nums) {
        return get(nums, 0, nums.length - 1);
    }

    private int get(int[] arr, int start, int end) {
        if (end - start < 2) {
            if (arr[start] > arr[end]) {
                return start;
            } else {
                return end;
            }
        }

        int k = (start + end) / 2;

        if (arr[k] > arr[k - 1] && arr[k] < arr[k + 1]) {
            return k;
        } else if (arr[k] > arr[k - 1]) {
            return get(arr, k, end);
        } else {
            return get(arr, start, k);
        }
    }

}

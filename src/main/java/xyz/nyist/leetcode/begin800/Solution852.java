package xyz.nyist.leetcode.begin800;

/**
 * @author: fucong
 * @Date: 2021/9/15 14:46
 * @Description:
 */
public class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        return get(arr, 0, arr.length - 1);
    }

    private int get(int[] arr, int start, int end) {
        if (end - start < 2) {
            return end;
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

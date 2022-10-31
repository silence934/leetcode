package xyz.nyist.leetcode.begin800;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/10/28 19:43
 * @Description:
 */
public class Solution907 {

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long ans = 0;
        long t = 7 + (long) Math.pow(10, 9);

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Arrays.fill(left, -1);
        LinkedList<Integer> list = new LinkedList<>();


        for (int i = n - 1; i > -1; i--) {
            if (list.isEmpty()) {
                list.addLast(i);
            } else {
                int k = arr[i];
                while (!list.isEmpty() && arr[list.getLast()] >= k) {
                    left[list.removeLast()] = i;
                }
                list.addLast(i);
            }
        }

        list.clear();


        for (int i = 0; i < n; i++) {
            if (list.isEmpty()) {
                list.addLast(i);
            } else {
                int k = arr[i];
                while (!list.isEmpty() && arr[list.getLast()] > k) {
                    right[list.removeLast()] = i;
                }
                list.addLast(i);
            }
        }
        
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * (right[i] - i - 1) * (i - left[i] - 1)) % t;
        }


        return (int) ans;
    }

}

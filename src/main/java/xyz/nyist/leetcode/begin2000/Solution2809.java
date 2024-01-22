package xyz.nyist.leetcode.begin2000;

import java.util.*;

public class Solution2809 {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(new Solution2809().minimumTime(Arrays.asList(5, 3, 2, 3, 10, 4, 7, 9, 1, 10), Arrays.asList(2, 0, 2, 0, 3, 3, 4, 4, 0, 1), 30));
        System.out.println(System.currentTimeMillis() - a);
    }

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums1.size(); i++) {
            sum1 += nums1.get(i);
            sum2 += nums2.get(i);
        }

        int[][] arr = new int[nums2.size()][2];
        for (int i = 0; i < nums2.size(); i++) {
            arr[i] = new int[]{i, nums2.get(i)};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        return minimumTime(nums1, nums2, x, sum1, sum2, new HashSet<>(), 1, Integer.MAX_VALUE, arr);
    }


    private int minimumTime(List<Integer> nums1, List<Integer> nums2, int x, int sum1, int sum2, Set<Integer> used, int cur, int min, int[][] arr) {
        if (cur >= min) {
            return -1;
        }

        if (x >= sum1) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < nums1.size(); i++) {
            nums1.set(i, nums1.get(i) + nums2.get(i));
            max = Math.max(max, nums1.get(i) + nums2.get(i) + nums2.get(i));
        }
        if (max <= sum2) {
            return -1;
        }


        int res = Integer.MAX_VALUE;
        for (int[] ints : arr) {
            int i = ints[0];
            if (used.contains(i)) {
                continue;
            }
            used.add(i);

            int old = nums1.get(i);
            nums1.set(i, 0);

            int t = minimumTime(new ArrayList<>(nums1), nums2, x, sum1 + sum2 - old, sum2, used, cur + 1, min, arr);

            if (t >= 0) {
                res = Math.min(res, t);
                min = Math.min(min, t);
            }

            nums1.set(i, old);
            used.remove(i);
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res + 1;
    }
}

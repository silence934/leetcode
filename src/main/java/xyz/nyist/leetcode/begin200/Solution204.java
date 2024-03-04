package xyz.nyist.leetcode.begin200;

import java.util.Arrays;

public class Solution204 {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 1) {
                ans++;
                for (long j = (long) i * i; ; j += i) {
                    if (j >= n) {
                        break;
                    }
                    arr[(int) j] = 0;
                }
            }
        }

        return ans;
    }
}

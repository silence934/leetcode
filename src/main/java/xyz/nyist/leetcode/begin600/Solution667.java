package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/9/8 11:16
 * @Description:
 */
public class Solution667 {

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];

        for (int i = 0; i < n - k; i++) {
            ans[i] = i + 1;
        }

        ans[n - k] = n;
        boolean b = false;
        for (int i = n - k + 1; i < n; i++) {
            if (b) {
                ans[i] = ans[i - 2] - 1;
                b = false;
            } else {
                ans[i] = ans[i - 2] + 1;
                b = true;
            }
        }

        return ans;
    }

}

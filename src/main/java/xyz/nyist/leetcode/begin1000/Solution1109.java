package xyz.nyist.leetcode.begin1000;

/**
 * @author: silence
 * @Date: 2022/11/25 14:03
 * @Description:
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                res[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + res[i];
        }


        return res;
    }
}

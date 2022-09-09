package xyz.nyist.leetcode.begin1800;

/**
 * @author: silence
 * @Date: 2021/7/23 14:40
 * @Description:
 */
public class Solution1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }

        int pre = 0;
        for (int i = 0; i < 52; i++) {
            pre += diff[i];
            if (i >= left && i <= right && pre == 0) {
                return false;
            }
        }

        return true;
    }

}

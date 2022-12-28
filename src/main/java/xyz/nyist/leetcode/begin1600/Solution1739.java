package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/28 18:32
 * @Description:
 */
public class Solution1739 {
    public int minimumBoxes(int n) {
        int cur = 1, i = 1, j = 1;
        while (n > cur) {
            n -= cur;
            i++;
            cur += i;
        }
        cur = 1;
        while (n > cur) {
            n -= cur;
            j++;
            cur++;
        }
        return (i - 1) * i / 2 + j;
    }
}

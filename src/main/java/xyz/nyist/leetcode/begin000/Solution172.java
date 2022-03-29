package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2022/3/25 10:35
 * @Description:
 */
public class Solution172 {

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

}

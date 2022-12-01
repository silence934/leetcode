package xyz.nyist.leetcode.begin200;

/**
 * @author: silence
 * @Date: 2022/12/1 19:00
 * @Description:
 */
public class Solution278 {
    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean isBadVersion(int version) {
        return false;
    }

}

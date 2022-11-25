package xyz.nyist.leetcode.begin1800;

/**
 * @author: silence
 * @Date: 2022/11/23 16:29
 * @Description:
 */
public class Solution2027 {
    public int minimumMoves(String s) {

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                ans++;
                i = i + 2;
            }
        }

        return ans;
    }
}

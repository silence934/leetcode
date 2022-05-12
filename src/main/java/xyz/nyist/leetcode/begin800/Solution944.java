package xyz.nyist.leetcode.begin800;

/**
 * @author: fucong
 * @Date: 2022/5/12 16:41
 * @Description:
 */
public class Solution944 {

    public int minDeletionSize(String[] strs) {
        int ans = 0;

        int n = strs[0].length();

        for (int i = 0; i < n; i++) {
            char c = 'a';
            for (String str : strs) {
                if (str.charAt(i) < c) {
                    ans++;
                    break;
                }
                c = str.charAt(i);
            }
        }

        return ans;
    }

}

package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/8 18:25
 * @Description:
 */
public class Solution1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        byte[] map = new byte[128];
        for (char c : allowed.toCharArray()) {
            map[c] = 1;
        }
        int ans = 0;

        for (String word : words) {

            boolean b = true;
            for (char c : word.toCharArray()) {
                if (map[c] == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                ans++;
            }
        }


        return ans;
    }

}

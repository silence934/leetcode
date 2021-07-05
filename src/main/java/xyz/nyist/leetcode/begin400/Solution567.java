package xyz.nyist.leetcode.begin400;

/**
 * @author: fucong
 * @Date: 2021/7/1 21:41
 * @Description:
 */
public class Solution567 {

    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[128];
        int[] windows = new int[128];
        int needTypeLen = 0;

        for (char c : s1.toCharArray()) {
            if (need[c] == 0) {
                needTypeLen++;
            }
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;

        char[] chars = s2.toCharArray();

        while (right < s2.length()) {
            char c = chars[right++];
            if (need[c] != 0) {
                windows[c]++;
                if (windows[c] == need[c]) {
                    valid++;
                }
            }

            if (right - left == s1.length()) {
                if (needTypeLen == valid) {
                    return true;
                }
                char k = chars[left++];
                if (need[k] != 0) {
                    if (windows[k] == need[k]) {
                        valid--;
                    }
                    windows[k]--;
                }

            }

        }
        return false;
    }

}

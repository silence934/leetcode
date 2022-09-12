package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/12 20:13
 * @Description:
 */
public class Offer16 {

    public int lengthOfLongestSubstring(String s) {
        byte[] map = new byte[128];

        char[] chars = s.toCharArray();

        int left = 0, right = 0;

        int res = 0;
        while (right < chars.length) {
            if (map[chars[right]] == 0) {
                map[chars[right]] = 1;
                right++;
                res = Math.max(res, right - left);
            } else {
                map[chars[left]] = 0;
                left++;
            }
        }

        return res;
    }

}

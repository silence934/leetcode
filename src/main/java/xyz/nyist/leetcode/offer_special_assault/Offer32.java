package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer32 {

    public boolean isAnagram(String s, String t) {
        if (s.equals(t) || s.length() != t.length()) {
            return false;
        }
        int[] map = new int[128];

        for (char c : s.toCharArray()) {
            map[c]++;
        }

        for (char c : t.toCharArray()) {
            if (--map[c] < 0) {
                return false;
            }
        }


        return true;

    }

}

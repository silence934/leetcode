package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/13 09:50
 * @Description:
 */
public class Offer17 {

    public static void main(String[] args) {
        System.out.println(new Offer17().minWindow("ADOBECODEBANC",
                                                   "ABC"));
    }

    public String minWindow(String s, String t) {
        String res = "";
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int length = t.length();

        char[] chars = s.toCharArray();
        int left = 0, right = 0;

        while (right < chars.length) {

            while (right < chars.length) {
                if (map[chars[right]] > 0) {
                    length--;
                }
                map[chars[right]]--;
                right++;
                if (length == 0) {
                    res = (res.length() == 0 || res.length() > right - length) ? s.substring(left, right) : res;
                    break;
                }
            }

            while (left < right && length == 0) {
                if (map[chars[left]] == 0) {
                    length++;
                }
                map[chars[left]]++;
                left++;

                if (length == 0) {
                    res = (res.length() == 0 || res.length() > right - left) ? s.substring(left, right) : res;
                }
            }

        }

        return res;
    }

}

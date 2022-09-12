package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/12 20:13
 * @Description:
 */
public class Offer14 {


    public static void main(String[] args) {
        System.out.println(new Offer14().checkInclusion("ab",
                                                        "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];

        for (char c : s1.toCharArray()) {
            map[c]++;
        }

        int length = s1.length();

        int left = 0, right = 0;
        char[] chars = s2.toCharArray();

        while (right < chars.length) {
            if (map[chars[right]] > 0) {
                map[chars[right]]--;
                length--;
                right++;
                if (length == 0) {
                    return true;
                }
            } else {
                length++;
                map[chars[left]]++;
                left++;
            }
        }


        return false;
    }

}

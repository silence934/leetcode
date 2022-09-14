package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/13 09:50
 * @Description:
 */
public class Offer19 {


    public static void main(String[] args) {
        System.out.println(new Offer19().validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validPalindrome1(s.substring(left + 1, right + 1)) || validPalindrome1(s.substring(left, right));
            }
        }

        return true;
    }


    private boolean validPalindrome1(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}

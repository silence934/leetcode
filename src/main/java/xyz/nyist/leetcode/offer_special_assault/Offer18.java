package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/13 09:50
 * @Description:
 */
public class Offer18 {

    public static void main(String[] args) {
        System.out.println(new Offer18().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char c = s.charAt(left);
            while (left < right && ((c < 'a' || c > 'z') && (c < '0' || c > '9'))) {
                left++;
                c = s.charAt(left);
            }
            c = s.charAt(right);
            while (left < right && ((c < 'a' || c > 'z') && (c < '0' || c > '9'))) {
                right--;
                c = s.charAt(right);
            }
            if (left > right) {
                break;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }


        return true;
    }

}

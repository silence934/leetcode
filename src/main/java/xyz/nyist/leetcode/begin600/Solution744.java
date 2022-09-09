package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/4/3 21:47
 * @Description:
 */
public class Solution744 {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        return find(letters, target, 0, letters.length);
    }

    private char find(char[] letters, char target, int start, int end) {
        int mid = (start + end - 1) / 2;

        if (letters[mid] > target) {
            if (mid == 0 || letters[mid - 1] <= target) {
                return letters[mid];
            }
            return find(letters, target, start, mid);
        } else {
            return find(letters, target, mid + 1, end);
        }

    }

}

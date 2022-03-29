package xyz.nyist.leetcode.begin1800;

/**
 * @author: fucong
 * @Date: 2022/3/29 19:34
 * @Description:
 */
public class Solution2024 {

    public static void main(String[] args) {
        Solution2024 solution2024 = new Solution2024();
        System.out.println(solution2024.maxConsecutiveAnswers("", 1));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }


    private int maxConsecutiveAnswers(String answerKey, int k, char c) {
        int l = 0, r = 0;
        int max = 0;
        char[] chars = answerKey.toCharArray();
        while (l < chars.length && r < chars.length) {
            if (chars[r] == c) {
                r++;
            } else {
                if (k > 0) {
                    k--;
                    r++;
                } else {
                    while (l < chars.length && chars[l] == c) {
                        l++;
                    }
                    l++;
                    k++;
                }
            }
            max = Math.max(max, r - l);
        }

        return max;
    }


}

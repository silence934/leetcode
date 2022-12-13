package xyz.nyist.leetcode.begin1800;

/**
 * @author: silence
 * @Date: 2022/12/13 20:16
 * @Description:
 */
public class Solution1832 {
    public boolean checkIfPangram(String sentence) {

        if (sentence.length() < 26) {
            return false;
        }


        byte[] bytes = new byte[26];


        for (char c : sentence.toCharArray()) {
            bytes[c - 'a'] = 1;
        }

        for (byte aByte : bytes) {
            if (aByte == 0) {
                return false;
            }
        }
        return true;
    }
}

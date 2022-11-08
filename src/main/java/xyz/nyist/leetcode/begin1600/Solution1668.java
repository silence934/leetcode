package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/3 14:14
 * @Description:
 */
public class Solution1668 {

    public int maxRepeating(String sequence, String word) {
        int ans = 0;

        int length = word.length();
        int index = -length;

        int t = 0;
        do {
            int i = sequence.indexOf(word, index + length);
            if ((t == 0 && i != -1) || i == index + length) {
                t++;
            } else {
                ans = Math.max(ans, t);
                t = 0;
                if (i != -1) {
                    index = index + 1 - length;
                    continue;
                }
            }
            index = i;
            if (index == -1) {
                break;
            }
        } while (true);


        return ans;
    }

}

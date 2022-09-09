package xyz.nyist.leetcode.begin1800;

/**
 * @author: silence
 * @Date: 2022/3/22 17:39
 * @Description: "AAABABB"
 */
public class Solution2038 {

    public static void main(String[] args) {
        Solution2038 solution2038 = new Solution2038();
        System.out.println(solution2038.winnerOfGame("AAABABB"));
    }


    public boolean winnerOfGame(String colors) {

        int a = 0, b = 0;

        char c = 'C';

        int t = 0;
        for (int i = 0; i < colors.length(); i++) {

            if (colors.charAt(i) == c) {
                if (++t >= 3) {
                    if (c == 'A') {
                        a++;
                    } else {
                        b++;
                    }
                }
            } else {
                t = 1;
                c = colors.charAt(i);
            }
        }

        return a > b;
    }


}

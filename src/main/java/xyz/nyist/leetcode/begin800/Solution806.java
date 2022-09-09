package xyz.nyist.leetcode.begin800;

/**
 * @author: silence
 * @Date: 2022/4/12 15:36
 * @Description:
 */
public class Solution806 {


    public int[] numberOfLines(int[] widths, String s) {


        int l = 0;
        int t = 0;
        for (int i = 0; i < s.length(); ) {
            t = 0;
            l++;
            while (i < s.length() && (t + widths[s.charAt(i) - 'a']) <= 100) {
                t = t + widths[s.charAt(i) - 'a'];
                i++;
            }

        }

        return new int[]{l, t};
    }

}

package xyz.nyist.leetcode.begin200;

/**
 * @author: silence
 * @Date: 2022/9/16 22:13
 * @Description:
 */
public class Solution223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int i = ((ax2 - ax1) * (ay2 - ay1)) + ((bx2 - bx1) * (by2 - by1));
        System.out.println(i);
        if (ax1 >= bx2 || ax2 <= bx1 || ay1 >= by2 || ay2 <= by1) {
            return i;
        }


        int a;
        if (ax1 < bx1) {
            if (ax2 > bx2) {
                a = bx2 - bx1;
            } else {
                a = ax2 - bx1;
            }
        } else {
            if (bx2 > ax2) {
                a = ax2 - ax1;
            } else {
                a = bx2 - ax1;
            }
        }
        int b;
        if (ay1 < by1) {
            if (ay2 > by2) {
                b = bx2 - by1;
            } else {
                b = ay2 - by1;
            }
        } else {
            if (by2 > ay2) {
                b = ay2 - ay1;
            } else {
                b = by2 - ay1;
            }
        }

        return i - a * b;
    }

}

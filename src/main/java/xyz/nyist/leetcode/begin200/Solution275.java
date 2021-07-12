package xyz.nyist.leetcode.begin200;

/**
 * @author: fucong
 * @Date: 2021/7/12 16:41
 * @Description:
 */
public class Solution275 {

    public int hIndex(int[] citations) {
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

}

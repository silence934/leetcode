package xyz.nyist.leetcode.offer_special_assault;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer39 {


    public static void main(String[] args) {
        System.out.println(new Offer39().largestRectangleArea(new int[]{2, 4}));
    }

    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> list = new LinkedList<>();

        int[] left = new int[heights.length];
        Arrays.fill(left, -1);
        for (int i = heights.length - 1; i > -1; i--) {
            while (!list.isEmpty() && heights[list.getLast()] > heights[i]) {
                left[list.removeLast()] = i;
            }
            list.addLast(i);
        }

        list.clear();
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!list.isEmpty() && heights[list.getLast()] > heights[i]) {
                right[list.removeLast()] = i;
            }
            list.addLast(i);
        }

        
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }


        return ans;
    }

}

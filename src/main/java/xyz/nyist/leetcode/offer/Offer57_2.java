package xyz.nyist.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/9/8 13:47
 * @Description:
 */
public class Offer57_2 {


    public static void main(String[] args) {
        Offer57_2 offer57_2 = new Offer57_2();
        System.out.println(Arrays.deepToString(offer57_2.findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int begin = 1, end = 2;

        int sum = 1;


        while (end <= target) {

            while (end <= target && sum < target) {
                sum += end;
                end++;
            }

            if (sum == target) {
                int[] arr = new int[end - begin];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = begin + i;
                }
                res.add(arr);
            }

            if (end > target) {
                break;
            }

            sum -= begin;
            begin++;
        }


        return res.toArray(new int[][]{});
    }

}

package xyz.nyist.writerTest.didi;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2021/8/5 19:54
 * @Description:
 */
public class Test1 {

    //n  数组   第k大的数   o（n）  o（1）

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int k = 3;

        int[] t = new int[k];

        for (int i = 0; i < numbers.length; i++) {
            if (i < k) {
                t[i] = numbers[i];
            } else {
                Arrays.sort(t);
                t[0] = Math.max(t[0], numbers[i]);
            }
        }
        Arrays.sort(t);


    }


}

package xyz.nyist.sort;

import java.util.Random;

/**
 * @author: fucong
 * @Date: 2022/4/26 21:25
 * @Description:
 */
public class ArrayUtils {

    private final static Random RANDOM = new Random();

    public static int[] randomArray(int length) {
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = RANDOM.nextInt(200) - 100;
        }
        return ans;
    }


    public static boolean compare(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

}

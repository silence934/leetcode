package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/9/24 21:59
 * @Description:
 */
public class Solution1652 {

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }

        int[] copy = new int[code.length];
        System.arraycopy(code, 0, copy, 0, code.length);


        int sum = 0;
        if (k > 0) {
            for (int i = 1; i < k + 1; i++) {
                sum += copy[i];
            }
            code[0] = sum;
            for (int i = 1; i < code.length; i++) {
                code[i] = code[i - 1] - copy[i] + copy[getIndex(i + k, code.length)];
            }
        } else {
            k = -k;
            for (int i = code.length - 2; i > code.length - 2 - k; i--) {
                sum += copy[i];
            }
            code[code.length - 1] = sum;

            for (int i = code.length - 2; i >= 0; i--) {
                code[i] = code[i + 1] - copy[i] + copy[getIndex(i - k, code.length)];
            }
        }


        return code;
    }


    int getIndex(int srcIndex, int n) {
        if (srcIndex < 0) {
            return n + srcIndex;
        }
        if (srcIndex < n) {
            return srcIndex;
        }
        return srcIndex - n;
    }

}

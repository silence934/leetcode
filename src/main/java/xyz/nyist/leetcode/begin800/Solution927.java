package xyz.nyist.leetcode.begin800;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/1 16:37
 * @Description:
 */
public class Solution927 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution927().threeEqualParts(new int[]{0, 1, 0, 1, 1})));
    }

    public int[] threeEqualParts(int[] arr) {

        int t = 0;
        for (int i : arr) {
            if (i == 1) {
                t++;
            }
        }
        if (t == 0) {
            return new int[]{0, 2};
        } else if (t % 3 != 0) {
            return new int[]{-1, -1};
        }


        int k = t / 3;

        boolean b = true;
        int zero = 0;
        int m = -1;
        int n = -1;
        for (int i = arr.length - 1; i > -1; i--) {

            if (arr[i] == 1) {
                b = false;
                k--;
                if (k == 0) {
                    n = i;
                    break;
                }
            } else if (b) {
                zero++;
            }
        }


        int c = 0;
        for (int i = n - 1; i > -1; i--) {
            if (arr[i] == 1) {
                break;
            }
            c++;
        }

        if (c < zero) {
            return new int[]{-1, -1};
        }
        n = n - (c - zero);


        k = t / 3;
        int p = arr.length - 1;
        for (int i = n - 1; i > -1; i--) {

            if (arr[p--] != arr[i]) {
                return new int[]{-1, -1};
            } else if (arr[i] == 1) {
                k--;
                if (k == 0) {
                    m = i;
                    break;
                }
            }
        }

        c = 0;
        for (int i = m - 1; i > -1; i--) {
            if (arr[i] == 1) {
                break;
            }
            c++;
        }

        if (c < zero) {
            return new int[]{-1, -1};
        }

        m = m - (c - zero) - 1;

        k = t / 3;
        p = arr.length - 1;
        for (int i = m; i > -1; i--) {
            if (arr[p--] != arr[i]) {
                return new int[]{-1, -1};
            } else if (arr[i] == 1) {
                k--;
                if (k == 0) {
                    break;
                }
            }
        }


        return new int[]{m, n};
    }

}

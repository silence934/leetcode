package xyz.nyist.writerTest.xiaomi;

import java.util.Arrays;

/**
 * @Author : silence
 * @Date: 2020-09-21 10:59
 * @Description :
 */
public class Test1 {
    public static void main(String[] args) {
        int[] a = new int[]{0};
        merge(a, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int A[], int m, int B[], int n) {
        if (A.length == 0) {
            if (n >= 0) {
                System.arraycopy(B, 0, A, 0, n);
            }
            return;
        }
        else if (B.length == 0) {
            return;
        }
        int a = 0, b = 0, t = 0;
        int[] newArr = new int[m + n];
        while (a < m && b < n) {
            if (A[a] > B[b]) {
                newArr[t++] = B[b++];
            }
            else {
                newArr[t++] = A[a++];
            }
        }
        while (a < m) {
            newArr[t++] = A[a++];
        }
        while (b < n) {
            newArr[t++] = B[b++];
        }
        System.arraycopy(newArr, 0, A, 0, n);
    }
}

package xyz.nyist.asd;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 19:01
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        if (k < 3) {
            System.out.println(1);
            return;
        }
        long[] arr = new long[k];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < k; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[k - 1]);
    }
}

package xyz.nyist.writerTest.xunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/9/12 19:50
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

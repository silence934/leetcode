package xyz.nyist.writerTest.doxiaoman;

import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2021/4/11 16:23
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[] res = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            for (int j = t; j < n + 1; j++) {
                if (res[j] == 0) {
                    res[j] = i + 1;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

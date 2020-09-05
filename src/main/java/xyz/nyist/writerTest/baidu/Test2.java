package xyz.nyist.writerTest.baidu;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2020-09-03 20:06
 * @Description :
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = m;
            }

            int w = 0;
            for (int i = 0; i < m; i++) {
                int k = in.nextInt();
                for (int j = 0; j < k; j++) {
                    int l = in.nextInt();
                    int r = in.nextInt();
                    for (int o = l; o <= r; o++) {
                        p[o]--;
                        if (p[o] == 0) {
                            w++;
                        }
                    }
                }
            }
            System.out.println(w);
            for (int i = 0; i < n; i++) {
                if (p[i] == 0) {
                    System.out.print(i + " ");
                }
            }

        }
    }
}

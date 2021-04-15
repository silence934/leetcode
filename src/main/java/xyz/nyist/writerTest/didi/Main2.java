package xyz.nyist.writerTest.didi;

import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2021/4/10 20:29
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] numbers = new int[n - 1];

        int t = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int curr = sc.nextInt();
            numbers[i] = curr - t;
            t = curr;
        }

        int max = 0;
        int start = -1;
        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] == x) {
                if (start == -1) {
                    start = i;
                }
            } else {
                int p = i + 1;
                while (p < n - 1 && numbers[p] != x) {
                    p++;
                }
                if (p == n - 1) {
                    max = Math.max(max, i - start);
                    start = i;
                } else {

                }

            }

        }

        System.out.println(n - max);

    }
}

package xyz.nyist.writerTest.byteDance;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 31, 37, 41, 43, 47, 51, 53, 57, 59, 61, 67, 71};
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int r = n / k;
            if ((n % k) != 0) {
                System.out.println(-1);
                continue;
            }
            int i;
            for (i = 0; i < a.length; i++) {
                int low = i + 1, hei = a.length - 1;
                while (low < hei) {
                    int h = -1;
                    if ((h = a[i] + a[low] + a[hei]) == r) {
                        System.out.println(a[i] * k + " " + a[low] * k + " " + a[hei] * k);
                        break;
                    }
                    else if (h < r) {
                        low++;
                    }
                    else {
                        hei--;
                    }
                }
                if (low != hei) {
                    break;
                }
            }
            if (i == a.length - 1) {
                System.out.println(-1);
            }
        }
    }


}

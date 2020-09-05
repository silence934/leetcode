package xyz.nyist.writerTest.anhengxinxi;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2020-08-23 09:56
 * @Description :
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] table = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};


        while (sc.hasNextInt()) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            if (m < 3) {
                System.out.println(table[m - 1] + d);
            }
            else if (isR(y)) {
                System.out.println(table[m - 1] + d + 1);
            }
            else {
                System.out.println(table[m - 1] + d);
            }

        }
    }

    private static boolean isR(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }
}

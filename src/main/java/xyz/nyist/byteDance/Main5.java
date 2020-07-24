package xyz.nyist.byteDance;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/17 20:26
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (in.hasNextInt()) {
            int t = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (t * 6 > (a + b * 2 + c * 3)) {
                System.out.println("No");
            }
            else {
                if (a >= b) {
                    System.out.println("Yes");
                }
                else {
                    //b>a
                    c += a;
                    if (c / 2 >= t) {
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println("No");
                    }
                }
            }
        }

    }
}

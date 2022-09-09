package xyz.nyist.writerTest.shengwang;

import java.util.Scanner;

/**
 * @Author : silence
 * @Date: 2021-03-27 15:21
 * @Description :
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = 1, t = 10;
        while (true) {
            if (m % n == 0) {
                System.out.println(String.valueOf(m).length());
                return;
            }
            m += t;
            t *= 10;
        }
    }

}

package xyz.nyist.writerTest.xunfei;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/9/12 19:52
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        String s = Long.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println(count);

    }
}

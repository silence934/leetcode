package xyz.nyist.writerTest.baidu;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2020-09-03 19:30
 * @Description : 5  0  90
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int number = 0;
        for (int i = 0; i < n; i++) {
            if (scanner.nextInt() == 0) {
                number++;
            }
        }

        if (number == 0) {
            System.out.println(-1);
            return;
        }

        long sum = 0;
        for (int i = number; i < n; i++) {
            sum += 5 * Math.pow(10, i);
        }

        long res = sum / 90 * 90;

        while (res > 0) {
            String s = Long.toString(res);
            int l = 0;
            for (int i = s.length() - 1; i > -1; i--) {
                if (s.charAt(i) == '5') {
                    l++;
                }
                else if (s.charAt(i) != '0') {
                    res += 90;
                    break;
                }
            }
            if (l == n - number) {
                System.out.println(res);
                return;
            }
            res += 90;
        }

    }
}

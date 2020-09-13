package xyz.nyist.writerTest.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2020-09-11 18:47
 * @Description :
 * 3
 * 123
 * 322
 * <p>
 * 223
 * <p>
 * b2>a
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int[] b = get(scanner.nextInt(), n);
        Arrays.sort(b);
        if (!test(0, b, 0, a)) {
            System.out.println(-1);
        }
    }


    public static boolean test(int k, int[] b, int res, int a) {
        if (k >= b.length) {
            if (res > a) {
                System.out.println(res);
                return true;
            }
            return false;
        }
        for (int i = b.length - 1; i >= 0; i--) {
            if (b[i] != -1) {
                int t = b[i];
                b[i] = -1;
                if (test(k + 1, b, res + (int) (t * Math.pow(10, k)), a)) {
                    return true;
                }
                b[i] = t;
            }
        }
        return false;
    }

    public static int[] get(int t, int n) {
        String s = Integer.toString(t);
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i) - '0';
        }
        return res;
    }

}

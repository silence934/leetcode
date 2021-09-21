package xyz.nyist.writerTest.huawei;


import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/5/24 17:40
 */
public class Test {

    //private static int[] map = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n < 3 || n > 7 || m < 0) {
            System.out.println(-1);
            return;
        }

        int start = (int) Math.pow(10, n - 1);

        int t = -1;
        int latest = -1;
        for (int i = start; i < start * 10; i++) {
            if (get(i, n) == i) {
                latest = i;
                if (++t == m) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(m * latest);


    }


    private static int get(int number, int n) {
        int res = 0;

        for (char c : String.valueOf(number).toCharArray()) {
            res += ((int) Math.pow(c - '0', n));
        }

        return res;
    }

}

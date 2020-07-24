package xyz.nyist.byteDance;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/14 18:49
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] nums = new int[T][2];
        for (int i = 0; i < T; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            int n = nums[i][0];
            int m = nums[i][1];
            String s = "" + n;
            int j = 0;
            for (; j < s.length() - m; j++) {
                if ((int) s.charAt(j) < (int) s.charAt(j + 1)) {
                    s = s.substring(0, j) + s.substring(j + 1);
                    m--;
                    j--;
                    if (m == 0) {
                        break;
                    }
                }
            }
            s = s.substring(0, s.length() - m);
            System.out.println(s);


        }
    }
}


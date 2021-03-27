package xyz.nyist.writerTest.meituan;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2021-03-13 15:56
 * @Description :
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美有一点懒惰， 她懒得学太多东西和做太多事情。有一次她躺在床上做一项作业时，发现答案都写歪了，请帮她翻转到正确位置。
 * <p>
 * 形式化地，给出一个n×m的二维数组，第 i 行第 j 列的数记为aij。现在要将这个二维数组沿着aii（1≤i≤min（n，m））翻转180°。
 * <p>
 * 例如：
 * <p>
 * <p>
 * <p>
 * 翻转成
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入n+1行，第一行两个数n和m，表示二维数组的行数和列数。
 * <p>
 * 接下来n行，每行m个数，第 i 行第 j 个数表示二维数组中的数aij
 * <p>
 * 1≤n,m≤100，0≤aij≤1000000，均为整数
 * <p>
 * <p>
 * 输出描述
 * 输出m行，表示翻转后的二维数组。
 * <p>
 * <p>
 * 样例输入
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 样例输出
 * 1 4 7
 * 2 5 8
 * 3 6 9
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        print(converter(map));
    }

    public static int[][] converter(int[][] map) {
        int m = map.length, n = map[0].length;
        int[][] res = new int[n][m];

        int k = Math.max(m, n);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i < m && j < n) {
                    res[j][i] = map[i][j];
                }
            }
        }


        return res;
    }

    public static void print(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}

package xyz.nyist.leetcode;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/6/21 21:52
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] chessboard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = scanner.nextInt();
            }
        }
        int res = checkWin(chessboard);
        if (res == 1) {
            System.out.println("黑棋赢");
        }
        else if (res == -1) {
            System.out.println("白棋赢");
        }
        else {
            System.out.println("不分胜负");
        }
    }

    public static int checkWin(int[][] cs) {
        int ROWS = cs.length - 1;
        for (int i = 0; i <= ROWS; i++) {
            for (int j = 0; j <= ROWS; j++) {
                int color;
                if ((color = cs[i][j]) != 0) {
                    // 向右查找
                    for (int n = 1; n <= 4; n++) {
                        if ((i + n >= 0) && (i + n) <= ROWS) {
                            if (cs[i + n][j] != 0) {
                                if (color == cs[i + n][j]) {
                                    cs[i][j] += color;
                                    if (cs[i][j] == 5 || cs[i][j] == -5) {
                                        return color;
                                    }
                                }
                            }
                            else {
                                cs[i][j] = color;
                                break;
                            }
                        }
                    }
                    cs[i][j] = color;

                    // 向下查找
                    for (int n = 1; n <= 4; n++) {
                        if ((j + n >= 0) && (j + n) <= ROWS) {
                            if (cs[i][j + n] != 0) {
                                if (color == cs[i][j + n]) {
                                    cs[i][j] += color;
                                    if (cs[i][j] == 5 || cs[i][j] == -5) {
                                        return color;
                                    }
                                }
                            }
                            else {
                                cs[i][j] = color;
                                break;
                            }
                        }
                    }
                    cs[i][j] = color;

                    // 左上
                    for (int n = 1; n <= 4; n++) {
                        if ((j - n >= 0) && (j - n) <= ROWS && (i - n) >= 0 && (i - n) <= ROWS) {
                            if (cs[i - n][j - n] != 0) {
                                if (color == cs[i - n][j - n]) {
                                    cs[i][j] += color;
                                    if (cs[i][j] == 5 || cs[i][j] == -5) {
                                        return color;
                                    }
                                }
                            }
                            else {
                                cs[i][j] = 1;// refresh count
                                break;
                            }
                        }
                    }
                    cs[i][j] = color;


                    // 左下
                    for (int n = 1; n <= 4; n++) {
                        if ((j + n >= 0) && (j + n) <= ROWS && (i - n) >= 0 && (i - n) <= ROWS) {
                            if (cs[i - n][j + n] != 0) {
                                if (color == cs[i - n][j + n]) {
                                    cs[i][j] += color;
                                    if (cs[i][j] == 5 || cs[i][j] == -5) {
                                        return color;
                                    }
                                }
                            }
                            else {
                                cs[i][j] = color;
                                break;
                            }
                        }
                    }
                    cs[i][j] = color;
                }
            }
        }
        return 0;
    }
}

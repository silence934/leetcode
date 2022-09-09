package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/9/17 14:49
 * @Description:
 */
public class Solution36 {

    public boolean isValidSudoku(char[][] board) {

        byte[][] column = new byte[9][9];
        byte[][] row = new byte[9][9];
        byte[][][] box = new byte[3][3][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int t = c - '0';

                    if (column[i][t] == 1 || row[j][t] == 1 || box[i / 3][j / 3][t] == 1) {
                        return false;
                    }

                    column[i][t] = 1;
                    row[j][t] = 1;
                    box[i / 3][j / 3][t] = 1;
                }


            }
        }

        return true;
    }

}

package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2021/9/16 17:42
 * @Description:
 */
public class Solution212 {

    public List<String> findWords(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (findWords(board, word)) {
                res.add(word);
            }
        }

        return res;
    }


    private boolean findWords(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (findWords(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean findWords(char[][] board, int i, int j, String word, int p) {
        if (p == word.length()) {
            return true;
        }
        if (board[i][j] == word.charAt(p)) {

            board[i][j] = '-';
            int m = board.length;
            int n = board[0].length;

            boolean res = (m == 1 && n == 1 && word.length() == 1) || (i > 0 && findWords(board, i - 1, j, word, p + 1))
                    || (i < m - 1 && findWords(board, i + 1, j, word, p + 1))
                    || (j < n - 1 && findWords(board, i, j + 1, word, p + 1))
                    || (j > 0 && findWords(board, i, j - 1, word, p + 1));

            board[i][j] = word.charAt(p);

            return res;
        }

        return false;
    }

}

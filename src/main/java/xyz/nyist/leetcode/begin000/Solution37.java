package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/12/17 21:44
 * @Description:
 */
public class Solution37 {
    public void solveSudoku(char[][] board) {

        List<Character> list = new ArrayList<>();

        for (char c = '1'; c <= '9'; c++) {
            list.add(c);
        }

        HashSet<Character>[] rSet = new HashSet[board.length];
        HashSet<Character>[] lSet = new HashSet[board.length];
        HashSet<Character>[] bSet = new HashSet[board.length];
        for (int i = 0; i < rSet.length; i++) {
            rSet[i] = new HashSet<>(list);
            lSet[i] = new HashSet<>(list);
            bSet[i] = new HashSet<>(list);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rSet[i].remove(board[i][j]);
                lSet[j].remove(board[i][j]);
                bSet[getBIndex(i, j)].remove(board[i][j]);
            }
        }


        solveSudoku(board, 0, 0, rSet, lSet, bSet);
    }


    public boolean solveSudoku(char[][] board, int i, int j, HashSet<Character>[] rSet, HashSet<Character>[] lSet, HashSet<Character>[] bSet) {
        if (i > 8 || j > 8) {
            return false;
        }
        Iterator<Character> iterator1 = rSet[i].iterator();
        Iterator<Character> iterator2 = lSet[j].iterator();
        Iterator<Character> iterator3 = bSet[getBIndex(i, j)].iterator();
        if (i == 8 && j == 8) {
            if (board[i][j] == '.') {
                char c = iterator1.next();
                if (rSet[i].size() != 1 || lSet[j].size() != 1 || bSet[getBIndex(i, j)].size() != 1
                        || c != iterator2.next() || c != iterator3.next()) {
                    return false;
                }
                board[i][j] = c;
                return true;
            }
            return true;
        }
        if (board[i][j] != '.') {
            if (j < 8) {
                return solveSudoku(board, i, j + 1, rSet, lSet, bSet);
            } else {

                return solveSudoku(board, i + 1, 0, rSet, lSet, bSet);
            }
        }

        List<Character> list = new ArrayList<>(rSet[i]);
        for (Character c : list) {
            if (lSet[j].contains(c) && bSet[getBIndex(i, j)].contains(c)) {
                rSet[i].remove(c);
                lSet[j].remove(c);
                bSet[getBIndex(i, j)].remove(c);
                board[i][j] = c;
                if (j < 8) {
                    if (solveSudoku(board, i, j + 1, rSet, lSet, bSet)) {
                        return true;
                    }
                } else {
                    if (solveSudoku(board, i + 1, 0, rSet, lSet, bSet)) {
                        return true;
                    }
                }
                rSet[i].add(c);
                lSet[j].add(c);
                bSet[getBIndex(i, j)].add(c);
                board[i][j] = '.';
            }
        }

        return false;
    }


    private int getBIndex(int i, int j) {
        return j / 3 * 3 + i / 3;

    }

}

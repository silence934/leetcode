package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: silence
 * @Description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/18 17:42
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {


        List<List<String>> res = new ArrayList<>();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }
        solve(map, 0, res);
        return res;
    }

    public void solve(char[][] map, int index, List<List<String>> res) {
        if (index == map.length) {
            res.add(mapToList(map));
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (isCan(map, index, i)) {
                map[index][i] = 'Q';
                solve(map, index + 1, res);
                map[index][i] = '.';
            }
        }

    }

    public boolean isCan(char[][] map, int c, int l) {
        int lx = c - 1, ly = l - 1;
        int rx = c - 1, ry = l + 1;
        while (lx > -1 && ly > -1) {
            if (map[lx--][ly--] == 'Q') {
                return false;
            }
        }
        while (rx > -1 && ry < map.length) {
            if (map[rx--][ry++] == 'Q') {
                return false;
            }
        }
        while (--c > -1) {
            if (map[c][l] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> mapToList(char[][] map) {
        List<String> list = new ArrayList<>();
        for (char[] chars : map) {
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        System.out.println(solution51.solveNQueens(4));
    }
}

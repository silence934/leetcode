package xyz.nyist.leetcode.begin1200;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: silence
 * @Date: 2021/8/1 16:12
 * @Description:
 */
public class Solution1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length && mat[i][j] == 1; j++) {
                count += mat[i][j];
            }
            list.add(new int[]{count, i});
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        priorityQueue.addAll(list);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[1];
        }

        return res;
    }

}

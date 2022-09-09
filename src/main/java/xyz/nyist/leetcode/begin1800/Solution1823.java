package xyz.nyist.leetcode.begin1800;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/5/4 13:42
 * @Description:
 */
public class Solution1823 {


    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            list.addLast(i);
        }
        return find(k, list, 0);
    }

    private int find(int k, LinkedList<Integer> list, int start) {
        System.out.println(list);
        if (list.size() == 1) {
            return list.getFirst();
        }

        start = (start + k - 1) % list.size();
        list.remove(start);

        return find(k, list, start + 1);
    }

}

package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/3/11 13:59
 * @Description:
 */
public class Solution77 {

    private List<List<Integer>> res = new ArrayList<>();

    private LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, 0);
        return res;
    }


    public void combine(int n, int k, int start) {
        if (n - start + list.size() < k) {
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            list.addLast(i);

            if (list.size() == k) {
                res.add(new ArrayList<>(list));
            } else if (list.size() < k) {
                combine(n, k, i);
            }

            list.removeLast();
        }

    }

}

package xyz.nyist.leetcode.begin800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/4/19 15:38
 * @Description:
 */
public class Solution821 {

    public int[] shortestToChar(String s, char c) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                target.add(i);
            }
        }

        int[] ans = new int[s.length()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = findTarget(i, target, 0, target.size());
        }
        return ans;
    }


    private int findTarget(int index, List<Integer> target, int left, int right) {
        if (index < target.get(left)) {
            if (left != 0) {
                return Math.min(target.get(left) - index, index - target.get(left - 1));
            }
            return target.get(left) - index;
        }
        if (index > target.get(right - 1)) {
            if (right != target.size()) {
                return Math.min(index - target.get(right - 1), target.get(right) - index);
            }
            return index - target.get(right - 1);
        }

        int mid = (left + right) / 2;

        if (index > target.get(mid)) {
            return findTarget(index, target, mid, right);
        } else if (index < target.get(mid)) {
            return findTarget(index, target, left, mid);
        } else {
            return 0;
        }
    }

}

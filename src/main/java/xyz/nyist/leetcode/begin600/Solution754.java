package xyz.nyist.leetcode.begin600;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/11/30 17:23
 * @Description:
 */
public class Solution754 {
    public int reachNumber(int target) {
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0, 1});
        Set<Integer> set = new HashSet<>();
        while (!list.isEmpty()) {
            int[] point = list.removeLast();
            if (set.contains(point[0])) {
                continue;
            }
            set.add(point[0]);
            if (point[0] == target) {
                return point[1] - 1;
            }
            list.addFirst(new int[]{point[0] + point[1], point[1] + 1});
            list.addFirst(new int[]{point[0] - point[1], point[1] + 1});
        }

        return -1;
    }


}

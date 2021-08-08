package xyz.nyist.leetcode.begin1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: fucong
 * @Date: 2021/7/26 11:06
 * @Description:
 */
public class Solution1743 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.computeIfAbsent(adjacentPair[0], k -> new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);

            map.computeIfAbsent(adjacentPair[1], k -> new ArrayList<>());
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        int[] res = new int[adjacentPairs.length + 1];
        res[0] = map.entrySet().stream().filter(k -> k.getValue().size() == 1).findFirst().get().getKey();

        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < res.length; i++) {
            List<Integer> list = map.get(res[i - 1]);
            res[i] = list.get(0).equals(res[i - 2]) ? list.get(1) : list.get(0);
        }

        return res;
    }

}

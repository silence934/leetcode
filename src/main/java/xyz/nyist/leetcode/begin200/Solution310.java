package xyz.nyist.leetcode.begin200;

import java.util.*;

/**
 * @author: fucong
 * @Date: 2022/4/6 18:47
 * @Description:
 */
public class Solution310 {

    public static void main(String[] args) {
        //6
        //[[3,0],[3,1],[3,2],[3,4],[5,4]]
        Solution310 solution310 = new Solution310();
        System.out.println(solution310.findMinHeightTrees(6,
                                                          new int[][]{
                                                                  new int[]{3, 0},
                                                                  new int[]{3, 1},
                                                                  new int[]{3, 4},
                                                                  new int[]{5, 4},
                                                                  new int[]{3, 2}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            Set<Integer> set = map.getOrDefault(edge[0], new HashSet<>());
            set.add(edge[1]);
            map.put(edge[0], set);

            set = map.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[0]);
            map.put(edge[1], set);
        }

        int[] parent = new int[n];
        int x = findMinHeightTrees(0, map, parent);
        int y = findMinHeightTrees(x, map, parent);


        List<Integer> path = new ArrayList<>();
        while (y != x) {
            path.add(y);
            y = parent[y];
        }
        path.add(y);

        if ((path.size() & 1) == 1) {
            ans.add(path.get(path.size() / 2));
        } else {
            ans.add(path.get(path.size() / 2));
            ans.add(path.get(path.size() / 2 - 1));
        }

        return ans;

    }


    public int findMinHeightTrees(int start, Map<Integer, Set<Integer>> map, int[] parent) {
        int res = start;
        parent[res] = -1;
        Set<Integer> used = new HashSet<>();
        used.add(start);

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(start);

        while (!list.isEmpty()) {
            Integer item = list.removeFirst();
            used.add(item);

            res = item;

            for (Integer i : map.get(item)) {
                if (!used.contains(i)) {
                    parent[i] = res;

                    list.addLast(i);
                }
            }

        }


        return res;
    }

}

package xyz.nyist.leetcode.begin2000;

import xyz.nyist.utils.ArrUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2861 {
    public static void main(String[] args) {
        int[][] a = ArrUtil.String2Arrays("[[67,58,24],[34,75,87],[24,38,59],[89,66,76],[59,59,96],[51,84,100],[92,49,69],[48,19,47],[6,12,1],[50,100,58],[73,10,53],[90,33,72],[28,25,68],[44,68,69],[21,54,10]]");

        List<List<Integer>> b = new ArrayList<>();
        for (int[] ints : a) {
            b.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
        }

        System.out.println(new Solution2861().maxNumberOfAlloys(3, 15, 36, b, Arrays.asList(25, 20, 36), Arrays.asList(19, 93, 49)));
    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {

        int l = 0, r = 100000000;

        while (l < r) {
            int mid = l + (r - l) / 2;

            boolean is = false;
            for (List<Integer> list : composition) {
                int need = 0;
                int i = 0;
                for (; i < list.size(); i++) {
                    int t = Math.max(list.get(i) * mid - stock.get(i), 0);
                    if (t > budget) {
                        r = mid;
                        break;
                    }
                    need += t * cost.get(i);
                    if (need > budget) {
                        r = mid;
                        break;
                    }
                }

                if (i == list.size()) {
                    is = true;
                    break;
                }
            }

            if (is) {
                l = mid + 1;
            }
        }

        return l - 1;
    }
}

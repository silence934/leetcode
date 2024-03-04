package xyz.nyist.leetcode.begin2000;

import xyz.nyist.utils.ArrUtil;

import java.util.*;

public class Solution2867 {

    //[[1,2],[1,3],[2,4],[2,5]]
    public static void main(String[] args) {
        System.out.println(new Solution2867().countPaths(5, ArrUtil.String2Arrays("[[1,2],[1,3],[2,4],[2,5]]")));
    }

    public long countPaths(int n, int[][] edges) {
        boolean[] primeList = getPrimeList(n);

        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        long ans = 0;

        //count[i] 从i出发能找到的所有非质数节点数量,包括i节点
        int[] count = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (!primeList[i]) {
                continue;
            }
            //节点是质数

            long t = 0;
            for (Integer p : map[i]) {
                //质数节点的子节点
                if (primeList[p]) {
                    continue;
                }
                if (count[p] == 0) {
                    LinkedList<Integer> queue = new LinkedList<>();
                    Set<Integer> used = new HashSet<>();
                    queue.addFirst(p);
                    while (!queue.isEmpty()) {
                        int cur = queue.removeLast();
                        used.add(cur);
                        for (Integer j : map[cur]) {
                            if (!primeList[j] && !used.contains(j)) {
                                queue.addFirst(j);
                            }
                        }
                    }

                    for (Integer j : used) {
                        count[j] = used.size();
                    }
                }

                int x = count[p];

                ans += t * x;
                t += x;
            }

            ans += t;
        }


        return ans;
    }


    private boolean[] getPrimeList(int n) {
        boolean[] res = new boolean[n + 1];
        Arrays.fill(res, true);
        res[1] = false;
        for (int i = 2; i < n + 1; i++) {
            if (res[i]) {
                for (long j = (long) i * i; ; j += i) {
                    if (j >= n + 1) {
                        break;
                    }
                    res[(int) j] = false;
                }
            }
        }
        return res;
    }


}

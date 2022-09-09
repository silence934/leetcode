package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/4/24 14:50
 * @Description:
 */
public class Solution210 {

    public static void main(String[] args) {
        Solution210 solution210 = new Solution210();
        System.out.println(Arrays.toString(solution210.findOrder(2, new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
        })));
    }

    private List<Integer>[] map;

    private boolean[] used;

    private boolean[] path;

    private List<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        used = new boolean[numCourses];
        path = new boolean[numCourses];
        map = new ArrayList[numCourses];
        ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            map[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!traverse(i)) {
                return new int[0];
            }
        }

        Collections.reverse(ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean traverse(int p) {

        if (path[p]) {
            return false;
        }

        if (used[p]) {
            return true;
        }
        used[p] = true;

        path[p] = true;

        for (Integer integer : map[p]) {

            if (!traverse(integer)) {
                return false;
            }
        }

        path[p] = false;

        ans.add(p);
        return true;
    }

}

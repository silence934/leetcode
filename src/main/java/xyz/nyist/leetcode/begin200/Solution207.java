package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/4/24 14:50
 * @Description:
 */
public class Solution207 {

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        System.out.println(solution207.canFinish(2, new int[][]{
                new int[]{1, 0}
        }));
    }

    private List<Integer>[] map;

    private boolean[] used;

    private boolean[] path;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        used = new boolean[numCourses];
        path = new boolean[numCourses];
        map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            map[prerequisite[0]].add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!used[i]) {
                path[i] = true;
                if (!canFinish(i)) {
                    return false;
                }
                path[i] = false;
            }
        }
        return true;
    }

    private boolean canFinish(int p) {

        for (Integer integer : map[p]) {
            if (path[integer]) {
                return false;
            }
            if (used[integer]) {
                return true;
            }
            path[integer] = true;
            if (!canFinish(integer)) {
                return false;
            }

            used[integer] = true;
            path[integer] = false;
        }

        return true;
    }

}

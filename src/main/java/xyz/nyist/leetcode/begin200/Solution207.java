package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/4/24 14:50
 * @Description:
 */
public class Solution207 {

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        System.out.println(solution207.canFinish(3, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 2},
                new int[]{2, 1},
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
            map[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!used[i]) {
                path[i] = true;
                used[i] = true;
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
                continue;
            }
            used[integer] = true;

            path[integer] = true;
            if (!canFinish(integer)) {
                return false;
            }

            path[integer] = false;
        }

        return true;
    }

}

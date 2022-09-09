package xyz.nyist.leetcode.begin800;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: silence
 * @Date: 2022/5/6 09:59
 * @Description:
 */
public class Solution933 {

    Queue<Integer> queue;

    public Solution933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        t = t - 3000;
        while (!queue.isEmpty() && queue.peek() < t) {
            queue.poll();
        }

        return queue.size();
    }

}

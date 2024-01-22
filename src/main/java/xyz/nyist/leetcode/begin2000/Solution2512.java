package xyz.nyist.leetcode.begin2000;

import java.util.*;

public class Solution2512 {

    public static void main(String[] args) {

        int[] aa = new int[]{12, 2, 3, 9, 6};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int a : aa) {
            queue.offer(a);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>();
        Set<String> negative = new HashSet<>();
        Collections.addAll(positive, positive_feedback);
        Collections.addAll(negative, negative_feedback);


        int[] score = new int[report.length];
        for (int i = 0; i < report.length; i++) {
            for (String s : report[i].split(" ")) {
                if (positive.contains(s)) {
                    score[i] += 3;
                } else if (negative.contains(s)) {
                    score[i]--;
                }
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            if (score[x] == score[y]) {
                return student_id[y] - student_id[x];
            }
            return score[x] - score[y];
        });


        System.out.println(Arrays.toString(score));
        for (int i = 0; i < report.length; i++) {
            if (queue.size() == k) {
                queue.poll();
            }
            queue.add(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(student_id[queue.poll()]);
        }

        Collections.reverse(res);
        return res;
    }
}

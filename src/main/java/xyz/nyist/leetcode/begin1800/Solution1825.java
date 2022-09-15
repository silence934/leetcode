package xyz.nyist.leetcode.begin1800;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: silence
 * @Date: 2022/9/14 16:16
 * @Description:
 */
public class Solution1825 {

    //["MKAverage","addElement","addElement","calculateMKAverage","addElement","addElement","calculateMKAverage","addElement","addElement","calculateMKAverage","addElement"]
//[[3,1],[17612],[74607],[],[8272],[33433],[],[15456],[64938],[],[99741]]
    public static void main(String[] args) {
        Solution1825 solution1825 = new Solution1825(3, 1);
        solution1825.addElement(17612);
        solution1825.addElement(74607);
        solution1825.addElement(8272);
        solution1825.addElement(33433);
        solution1825.addElement(15456);
        solution1825.addElement(64938);
        int i = solution1825.calculateMKAverage();
        solution1825.addElement(99741);
        System.out.println(i);
    }

    int m, k;

    PriorityQueue<Integer> queue1;

    PriorityQueue<Integer> queue2;

    PriorityQueue<Integer> queue3;

    PriorityQueue<Integer> queue4;

    LinkedList<Integer> list;

    private int sum;


    public Solution1825(int m, int k) {
        this.m = m;
        this.k = k;
        this.sum = 0;
        this.queue1 = new PriorityQueue<>();
        this.queue2 = new PriorityQueue<>((a, b) -> b - a);
        this.queue3 = new PriorityQueue<>();
        this.queue4 = new PriorityQueue<>((a, b) -> b - a);
        this.list = new LinkedList<>();
    }

    public void addElement(int num) {
        if (list.size() < m) {
            addElement1(num);
        } else {
            Integer first = list.removeFirst();
            if (queue3.remove(first)) {
                queue4.remove(first);
                sum -= first;
            } else {
                if (queue1.remove(first)) {
                    if (!queue3.isEmpty()) {
                        Integer poll = queue4.poll();
                        queue3.remove(poll);
                        queue1.offer(poll);
                        sum -= poll;
                    }
                } else if (queue2.remove(first)) {
                    if (!queue3.isEmpty()) {
                        Integer poll = queue3.poll();
                        queue4.remove(poll);
                        queue2.offer(poll);
                        sum -= poll;
                    }
                }
            }

            addElement1(num);
        }
    }

    public void addElement1(int num) {
        list.addLast(num);
        if (queue1.size() < k) {
            queue1.offer(num);
            return;
        } else if (queue2.size() < k) {
            if (queue1.peek() > num) {
                queue2.offer(queue1.poll());
                queue1.offer(num);
            } else {
                queue2.offer(num);
            }
            return;
        }

        if (num < queue1.peek()) {
            Integer poll = queue1.poll();
            queue1.offer(num);
            queue3.offer(poll);
            queue4.offer(poll);
            sum += poll;
        } else if (num > queue2.peek()) {
            Integer poll = queue2.poll();
            queue2.offer(num);
            queue3.offer(poll);
            queue4.offer(poll);
            sum += poll;
        } else {
            queue3.offer(num);
            queue4.offer(num);
            sum += num;
        }
    }


    public int calculateMKAverage() {
        if (m > list.size()) {
            return -1;
        }
        return sum / (m - k - k);
    }

}

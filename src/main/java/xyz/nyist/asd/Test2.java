package xyz.nyist.asd;


import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 19:01
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String[] strs = in.nextLine().split(" ");
        Node head = null;
        Node pre = null;
        for (int i = 0; i < strs.length; i++) {
            Node node = new Node(Integer.parseInt(strs[i]));
            if (i == 0) {
                head = node;
            }
            else {
                pre.next = node;
            }
            pre = node;
        }
        head = reverseKGroup(head, k, strs.length);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static Node reverseKGroup(Node head, int k, int l) {
        Node p = head;
        for (int i = 1; i < l; i++) {
            if ((i + 1) % k == 0) {
                p = reversal(p, i - k + 1, i);
            }
            else if (i == l - 1) {
                p = reversal(p, l - l % k, i);
            }
        }
        return p;
    }

    public static Node reversal(Node head, int start, int end) {
        int k = 0;
        Node pre = null, next, p = head, m = null, n = null;
        while (head != null) {
            if (k == start - 1) {
                m = head;
            }
            else if (k == start) {
                n = head;
            }
            if (k > start && k <= end) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                if (k == end) {
                    if (m == null) {
                        p = pre;
                    }
                    else {
                        m.next = pre;
                    }
                    n.next = next;
                }
            }
            else {
                pre = head;
                head = head.next;
            }
            k++;
        }
        return p;
    }

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

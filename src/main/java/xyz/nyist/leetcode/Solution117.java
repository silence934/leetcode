package xyz.nyist.leetcode;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/8/4 0:25
 */
public class Solution117 {
    public static void main(String[] args) {
        Solution117 solution117 = new Solution117();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node1.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(solution117.connect(node1));
    }

    public Node connect(Node root) {
        Node left = root;
        while (left != null) {
            Node next = left, pre = null;
            while (next != null) {
                if (next.left != null && next.right != null) {
                    if (left == next) {
                        left = next.left;
                    }
                    if (pre != null) {
                        pre.next = next.left;
                    }
                    next.left.next = next.right;
                    pre = next.right;
                }
                else if (next.left != null) {
                    if (left == next) {
                        left = next.left;
                    }
                    if (pre != null) {
                        pre.next = next.left;
                    }
                    pre = next.left;
                }
                else if (next.right != null) {
                    if (left == next) {
                        left = next.right;
                    }
                    if (pre != null) {
                        pre.next = next.right;
                    }
                    pre = next.right;
                }
                next = next.next;
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
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

package xyz.nyist.leetcode.begin1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1466 {


    public static void main(String[] args) {
        Solution1466 solution1466 = new Solution1466();
        System.out.println(solution1466.minReorder(3, new int[][]{
                new int[]{1, 2},
                new int[]{2, 0}
        }));
    }

    class Node {
        public int x;
        public boolean canAccess;

        public Node(int x, boolean canAccess) {
            this.x = x;
            this.canAccess = canAccess;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", canAccess=" + canAccess +
                    '}';
        }
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<Node>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            nodes[connection[0]].add(new Node(connection[1], true));
            nodes[connection[1]].add(new Node(connection[0], false));
        }

        System.out.println("xxx:" + Arrays.toString(nodes));
        return traverse(0, nodes, new HashSet<>());
    }

    public int traverse(int p, ArrayList<Node>[] nodes, Set<Integer> traversed) {
        int res = 0;

        traversed.add(p);
        for (Node node : nodes[p]) {
            if (traversed.contains(node.x)) {
                continue;
            }

            if (node.canAccess) {
                System.out.println(p + "_" + node.x);
                res++;
            }
            res += traverse(node.x, nodes, traversed);
        }

        System.out.println(p + ":" + res);
        return res;
    }

}

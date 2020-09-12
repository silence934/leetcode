package xyz.nyist.writerTest.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/9/12 14:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int m = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            s = scanner.nextLine();
            int p = Integer.parseInt(s.split(" ")[0]);
            String f = s.split(" ")[1];
            int c = Integer.parseInt(s.split(" ")[2]);

            Node node;
            if ((node = map.get(p)) == null) {
                node = new Node();
                if ("left".equals(f)) {
                    node.left = c;
                }
                else {
                    node.right = c;
                }
                map.put(p, node);
            }
            else {
                if ("left".equals(f)) {
                    node.left = c;
                }
                else {
                    node.right = c;
                }
                map.put(p, node);
            }
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (test(key, map)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean test(Integer key, Map<Integer, Node> map) {
        Node node = map.get(key);
        if (node.left != 0 && node.right != 0) {
            Node left = map.get(node.left);
            if (left != null) {
                return false;
            }
            Node right = map.get(node.right);
            return right == null;
        }
        return false;
    }

    private static class Node {
        public int left;
        public int right;

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

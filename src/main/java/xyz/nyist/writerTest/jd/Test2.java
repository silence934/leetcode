package xyz.nyist.writerTest.jd;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2020-08-27 20:34
 * @Description :
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] chars = scanner.nextLine().trim().split(" ");
        Integer[] nums = new Integer[n];
        int i = 0;
        for (String aChar : chars) {
            nums[i++] = Integer.parseInt(chars[i++]);
        }
        Node root = create(nums, 0);
        System.out.println(test(root));
    }


    public static int test(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Math.max(root.var + test(root.left), root.var + test(root.right)), root.var + test(root.right));
    }

    public static Node create(Integer[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        Node root = new Node(nums[k]);
        root.left = create(nums, k);
        root.mid = create(nums, k);
        root.right = create(nums, k);
        return root;
    }

    public static int getTop(int k) {
        int sum = 1, t = 0;
        while (sum < k) {
            t++;
            sum += sum * 2 + 1;
        }
        return t;
    }

    public static class Node {
        Node left;
        Node right;
        Node mid;
        int var;

        public Node(int var) {
            this.var = var;
        }
    }
}

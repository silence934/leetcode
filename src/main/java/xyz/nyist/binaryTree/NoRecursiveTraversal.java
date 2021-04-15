package xyz.nyist.binaryTree;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

import java.util.Stack;

/**
 * @Author: silence
 * @Description: 二叉树非递归遍历
 * @Date:Create：in 2020/7/15 14:51
 */
public class NoRecursiveTraversal {

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]");
        TreeUtil.show(tree);
        System.out.println("前序遍历:");
        preTraversal(tree);
        System.out.println();
        System.out.println("前序遍历1:");
        preTraversal1(tree);
        System.out.println();
        System.out.println("中序遍历:");
        inorderTraversal(tree);
        System.out.println();
        System.out.println("后序遍历:");
        postTraversal(tree);
    }

    private static void preTraversal(TreeNode root) {
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                System.out.print(temp.val + " ");
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = null;
            }
        }
    }

    private static void preTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
            System.out.print(temp.val + " ");
        }
    }

    private static void inorderTraversal(TreeNode root) {
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = null;
            }
        }
    }

    private static void postTraversal(TreeNode root) {
        TreeNode temp = root, per = null;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right != null && temp.right.val != per.val) {
                //顶元素是否存在右孩子，如果存在并且没有被访问
                temp = temp.right;
            } else {
                per = stack.pop();
                System.out.print(per.val + " ");
                temp = null;
            }
        }
    }

}

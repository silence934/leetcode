package xyz.nyist.binaryTree;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: silence
 * @Description: 二叉树非递归遍历
 * @Date:Create：in 2020/7/15 14:51
 */
public class NoRecursiveTraversal {

    public static void main(String[] args) {
        System.out.println("前序遍历:");
        preTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]"));
        System.out.println();
        System.out.println("中序遍历:");
        inorderTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]"));
        System.out.println();
        System.out.println("后序遍历:");
        postTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]"));
    }

    private static void preTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
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
            }
            else {
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
            }
            else {
                per = stack.pop();
                System.out.print(per.val + " ");
                temp = null;
            }
        }
    }

}
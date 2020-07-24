package xyz.nyist.binaryTree;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

/**
 * @Author: silence
 * @Description: 二叉树递归遍历
 * @Date:Create：in 2020/7/15 14:51
 */
public class RecursiveTraversal {
    public static void main(String[] args) {
        System.out.println("前序遍历:");
        preTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7]"));
        System.out.println();
        System.out.println("中序遍历:");
        inorderTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7]"));
        System.out.println();
        System.out.println("后序遍历:");
        postTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7]"));
    }

    private static void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preTraversal(root.left);
        preTraversal(root.right);
    }

    private static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    private static void postTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraversal(root.left);
        postTraversal(root.right);
        System.out.print(root.val + " ");
    }

}

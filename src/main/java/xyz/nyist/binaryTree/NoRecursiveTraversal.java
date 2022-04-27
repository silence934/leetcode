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
        System.out.println("中序遍历1:");
        inorderTraversal1(tree);
        System.out.println();
        System.out.println("后序遍历:");
        postTraversal(tree);
        System.out.println();
        System.out.println("后序遍历1:");
        postTraversal1(tree);
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

    private static void inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean b = true;
        while (!stack.isEmpty()) {
            TreeNode node;
            if (b) {
                node = stack.pop();
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
            }
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.add(node.right);
                b = true;
            } else {
                b = false;
            }
        }
    }

    private static void postTraversal(TreeNode root) {
        TreeNode temp = root, pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right != null && pre != null && temp.right.val != pre.val) {
                //顶元素是否存在右孩子，如果存在并且没有被访问
                temp = temp.right;
            } else {
                pre = stack.pop();
                System.out.print(pre.val + " ");
                temp = null;
            }
        }
    }


    private static void postTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode pre = null;
        boolean b = true;
        while (!stack.isEmpty()) {
            if (b) {
                TreeNode node = stack.pop();
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
            }

            TreeNode peek = stack.peek();
            if (peek.right != null && peek.right != pre) {
                stack.add(peek.right);
                b = true;
            } else {
                pre = peek;
                System.out.print(peek.val + " ");
                stack.pop();
                b = false;
            }

        }
    }

}

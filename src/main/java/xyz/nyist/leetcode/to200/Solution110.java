package xyz.nyist.leetcode.to200;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: silence
 * @Description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/6 10:08
 */
public class Solution110 {

    static class Node {
        TreeNode treeNode;
        int index;

        public Node(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 0));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.treeNode.right != null) {
                stack.add(new Node(node.treeNode.right, node.index + 1));
            }
            else {
                set.add(node.index);
            }
            if (node.treeNode.left != null) {
                stack.add(new Node(node.treeNode.left, node.index + 1));
            }
            else {
                set.add(node.index);
            }
        }
        return Collections.max(set) - Collections.min(set) < 2;
    }


    public static void main(String[] args) {
        // [1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
        Solution110 solution110 = new Solution110();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode14 = new TreeNode(14);
        TreeNode treeNode15 = new TreeNode(15);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;
        treeNode6.left = treeNode12;
        treeNode6.right = treeNode13;

        treeNode8.left = treeNode14;
        treeNode8.right = treeNode15;

        TreeOperation.show(treeNode1);

        System.out.println(solution110.isBalanced1(treeNode1));
    }


    public boolean isBalanced1(TreeNode root) {
        return test(root) != -1;
    }

    public int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = test(root.left);
        if (left == -1) {
            return -1;
        }
        int right = test(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

}

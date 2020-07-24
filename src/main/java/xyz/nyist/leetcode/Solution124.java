package xyz.nyist.leetcode;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

/**
 * @Author: silence
 * @Description: 给定一个非空二叉树，返回其最大路径和。 本题中，路径被定义为一条从树中任意节点出发，
 * 达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * @Date:Create：in 2020/6/21 15:21
 */
public class Solution124 {


    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    public int maxGain(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null) {
            left = maxGain(root.left);
        }
        if (root.right != null) {
            right = maxGain(root.right);
        }
        int r = Integer.max(root.val + left, root.val + right);
        max = Integer.max(r, max);
        max = Integer.max(root.val, max);
        max = Integer.max(root.val + left + right, max);
        max = Integer.max(root.val + left, max);
        max = Integer.max(root.val + right, max);
        return Integer.max(r, root.val);
    }

    public static void main(String[] args) {
        Solution124 solution124 = new Solution124();

        /*TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode31;
        treeNode4.right = treeNode5;
        treeNode4.left = treeNode7;
        treeNode31.left = treeNode6;

        System.out.println(solution124.maxPathSum(treeNode3));*/


        TreeNode treeNode09 = new TreeNode(9);
        TreeNode treeNode06 = new TreeNode(6);
        TreeNode treeNode13 = new TreeNode(-3);
        TreeNode treeNode16 = new TreeNode(-6);
        TreeNode treeNode02 = new TreeNode(2);
        TreeNode treeNode021 = new TreeNode(2);
        TreeNode treeNode161 = new TreeNode(-6);
        TreeNode treeNode162 = new TreeNode(-6);
        TreeNode treeNode163 = new TreeNode(-6);
        treeNode09.left = treeNode06;
        treeNode09.right = treeNode13;
        treeNode13.left = treeNode16;
        treeNode13.right = treeNode02;
        treeNode02.left = treeNode021;
        treeNode021.left = treeNode161;
        treeNode021.right = treeNode162;
        treeNode161.left = treeNode163;
        TreeOperation.show(treeNode09);
        System.out.println(solution124.maxPathSum(treeNode09));


    }

}

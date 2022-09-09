package xyz.nyist.leetcode.begin600;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2021/7/27 18:50
 * @Description:
 */
public class Solution671 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new Solution671().findSecondMinimumValue(node1));
    }

    private int min;

    private int res = Integer.MAX_VALUE;

    private boolean is = false;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        get(root);
        return is ? res : -1;
    }

    public void get(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val > min && res >= root.val) {
            is = true;
            res = root.val;
        }
        get(root.left);
        get(root.right);
    }

}

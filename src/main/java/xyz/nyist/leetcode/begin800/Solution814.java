package xyz.nyist.leetcode.begin800;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Solution814 {


    public TreeNode pruneTree(TreeNode root) {

        TreeNode node = pruneTree1(root);
        if (node.val == 2) {
            node.val = 0;
        } else if (node.val == 0 && (node.left == null && node.right == null)) {
            return null;
        }

        return node;
    }

    public TreeNode pruneTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        pruneTree1(root.left);
        pruneTree1(root.right);

        if (root.left != null) {
            if (root.left.val == 0) {
                root.left = null;
            } else if (root.left.val == 2) {
                root.left.val = 0;
            }
        }

        if (root.right != null) {
            if (root.right.val == 0) {
                root.right = null;
            } else if (root.right.val == 2) {
                root.right.val = 0;
            }
        }

        if (root.val == 0 && (root.left != null || root.right != null)) {
            root.val = 2;
        }

        return root;
    }

}

package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2021/6/24 15:46
 * @Description:
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);

        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

}

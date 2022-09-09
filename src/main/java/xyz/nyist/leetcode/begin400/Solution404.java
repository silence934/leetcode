package xyz.nyist.leetcode.begin400;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2021/6/29 14:16
 * @Description:
 */
public class Solution404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.right);
            } else {
                return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            }
        } else {
            return sumOfLeftLeaves(root.right);
        }
    }
}

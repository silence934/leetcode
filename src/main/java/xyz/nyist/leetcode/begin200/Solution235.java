package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.TreeNode;

/**
 * @author: fucong
 * @Date: 2021/6/29 11:06
 * @Description:
 */
public class Solution235 {
    int min, max;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.min = Math.min(p.val, q.val);
        this.max = Math.max(p.val, q.val);
        return test(root);
    }


    private TreeNode test(TreeNode root) {
        if (root.val > min && root.val < max) {
            return root;
        }
        if (root.val == min || root.val == max) {
            return root;
        }
        if (root.val > max) {
            return test(root.left);
        }
        return test(root.right);
    }
}

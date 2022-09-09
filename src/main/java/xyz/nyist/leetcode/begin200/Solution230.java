package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2021/6/29 10:14
 * @Description:
 */
public class Solution230 {

    private int t;

    public int kthSmallest(TreeNode root, int k) {
        this.t = k;
        return test(root);
    }

    private int test(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftResult = test(root.left);
        if (leftResult != -1) {
            return leftResult;
        }

        if (--t == 0) {
            return root.val;
        }

        return test(root.right);
    }

}

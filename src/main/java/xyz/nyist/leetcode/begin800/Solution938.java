package xyz.nyist.leetcode.begin800;

import xyz.nyist.utils.TreeNode;

public class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        return (low <= root.val && root.val <= high ? root.val : 0) + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


}

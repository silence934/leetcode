package xyz.nyist.leetcode.begin400;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 0)[1];
    }

    int[] findBottomLeftValue(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            return new int[]{deep, root.val};
        }
        if (root.right == null) {
            return findBottomLeftValue(root.left, deep + 1);
        } else if (root.left == null) {
            return findBottomLeftValue(root.right, deep + 1);
        } else {
            int[] left = findBottomLeftValue(root.left, deep + 1);
            int[] right = findBottomLeftValue(root.right, deep + 1);
            return left[0] >= right[0] ? left : right;
        }
    }


}

package xyz.nyist.leetcode.begin1200;

import xyz.nyist.utils.TreeNode;

/**
 * @author: fucong
 * @Date: 2021/6/30 15:33
 * @Description:
 */
public class Solution1372 {

    int max = 0;

    public int maxSumBST(TreeNode root) {
        test(root);
        return max;
    }


    private int[] test(TreeNode root) {
        if (root == null) {
            // 是都是bst   最大值  最小值  和
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = test(root.left);
        int[] right = test(root.right);

        if (left[0] == 1 && right[0] == 1
                && root.val > left[1] && root.val < right[2]) {

            int t = root.val + left[3] + right[3];
            max = Math.max(max, t);

            return new int[]{1,
                    Math.max(root.val, right[1]),
                    Math.min(root.val, left[2]),
                    t};
        } else {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
    }


}

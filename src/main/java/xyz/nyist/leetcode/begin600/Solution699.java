package xyz.nyist.leetcode.begin600;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

/**
 * @author: silence
 * @Date: 2022/9/10 22:42
 * @Description:
 */
public class Solution699 {


    public static void main(String[] args) {
        System.out.println(new Solution699().trimBST(TreeUtil.createTree("[3,0,4,null,2,null,null,1]"), 1, 3));
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }


        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);


        return root;
    }

}

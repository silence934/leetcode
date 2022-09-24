package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer49 {

    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;

        sumNumbers(root, "");
        return sum;
    }


    void sumNumbers(TreeNode root, String v) {

        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(v + root.val);
            return;
        }

        if (root.left != null) {
            sumNumbers(root.left, v + root.val);
        }
        if (root.right != null) {
            sumNumbers(root.right, v + root.val);

        }


    }

}

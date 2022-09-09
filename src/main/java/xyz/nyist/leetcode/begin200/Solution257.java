package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2021/6/29 11:36
 * @Description:
 */
public class Solution257 {

    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        test(root, "");
        return res;
    }


    private void test(TreeNode root, String path) {
        if (!"".equals(path)) {
            path = path + "->" + root.val;
        } else {
            path = "" + root.val;
        }
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) {
            test(root.left, path);
        }
        if (root.right != null) {
            test(root.right, path);
        }
    }
}

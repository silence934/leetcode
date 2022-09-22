package xyz.nyist.leetcode.begin400;

import xyz.nyist.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Solution515 {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        list.addFirst(null);

        List<Integer> res = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        while (!list.isEmpty()) {
            TreeNode node = list.removeLast();
            if (node == null) {
                res.add(max);
                max = Integer.MIN_VALUE;
            } else {
                max = Math.max(max, node.val);
                if (node.left != null) {
                    list.addFirst(node.left);
                }
                if (node.right != null) {
                    list.addFirst(node.right);
                }
                if (!list.isEmpty() && list.getLast() == null) {
                    list.addFirst(null);
                }
            }
        }
        res.remove(res.size() - 1);
        return res;
    }

}

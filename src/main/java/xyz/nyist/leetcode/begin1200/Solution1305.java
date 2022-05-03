package xyz.nyist.leetcode.begin1200;

import xyz.nyist.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: fucong
 * @Date: 2022/5/1 20:25
 * @Description:
 */
public class Solution1305 {

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        traverse(root1);
        traverse(root2);

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root.val);
        traverse(root.left);
        traverse(root.right);
    }

}

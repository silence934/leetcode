package xyz.nyist.leetcode.begin800;

import xyz.nyist.utils.TreeNode;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Solution919 {


    TreeNode root;

    LinkedList<TreeNode> list;

    public Solution919(TreeNode root) {
        this.root = root;
        this.list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            TreeNode last = list.getLast();
            if (last.left != null && last.right != null) {
                list.addFirst(last.left);
                list.addFirst(last.right);
            } else {
                break;
            }
            list.removeLast();
        }
    }

    public int insert(int v) {
        TreeNode node = list.getLast();
        if (node.left == null) {
            node.left = new TreeNode(v);
        } else {
            node.right = new TreeNode(v);
            list.addFirst(node.left);
            list.addFirst(node.right);
            list.removeLast();
        }
        return node.val;
    }


    public TreeNode get_root() {
        return this.root;
    }

}

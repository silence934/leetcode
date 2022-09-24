package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.TreeNode;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer48 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeLast();
            if (node == null) {
                sb.append("n").append(",");
            } else {
                sb.append(node.val).append(",");
                list.addFirst(node.left);
                list.addFirst(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        int index = 0;

        String[] split = data.split(",");

        String s = split[index++];
        if (s.equals("n")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));


        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (index < split.length) {
            TreeNode node = list.removeLast();
            s = split[index++];
            if (s.equals("n")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(s));
                list.addFirst(node.left);
            }

            s = split[index++];
            if (s.equals("n")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(s));
                list.addFirst(node.right);
            }

        }


        return root;
    }


}

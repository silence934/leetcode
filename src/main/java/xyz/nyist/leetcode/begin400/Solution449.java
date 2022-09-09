package xyz.nyist.leetcode.begin400;

import xyz.nyist.utils.TreeNode;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/5/11 10:35
 * @Description:
 */
public class Solution449 {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            TreeNode node = list.removeLast();
            if (node == null) {
                sb.append("n,");
            } else {
                sb.append(node.val).append(",");
                list.addFirst(node.left);
                list.addFirst(node.right);
            }
        }
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data == null) {
            return null;
        }

        String[] split = data.split(",");
        if ("n".equals(split[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < split.length; i++) {
            TreeNode parent = list.removeLast();
            String left = split[i];
            if (!"n".equals(left)) {
                parent.left = new TreeNode(Integer.parseInt(split[i]));
                list.addFirst(parent.left);
            }
            i++;
            String right = split[i];
            if (!"n".equals(right)) {
                parent.right = new TreeNode(Integer.parseInt(split[i]));
                list.addFirst(parent.right);
            }
        }

        return root;
    }

}

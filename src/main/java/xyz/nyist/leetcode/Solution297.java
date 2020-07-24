package xyz.nyist.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: silence
 * @Description: 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/16 10:36
 */
public class Solution297 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(",");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                sb.append(node.left.val).append(",");
            }
            else {
                sb.append("null").append(",");
            }
            if (node.right != null) {
                queue.add(node.right);
                sb.append(node.right.val).append(",");
            }
            else {
                sb.append("null").append(",");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] tre = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tre[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String left = tre[i++], right = tre[i++];
            if (!"null".equals(left)) {
                TreeNode tLeft = new TreeNode(Integer.parseInt(left));
                queue.add(tLeft);
                node.left = tLeft;
            }
            if (!"null".equals(right)) {
                TreeNode RLeft = new TreeNode(Integer.parseInt(right));
                queue.add(RLeft);
                node.right = RLeft;
            }
        }

        return root;
    }


    public static void main(String[] args) {
        Solution297 solution297 = new Solution297();


        System.out.println("---------------------");

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode31;
        treeNode4.right = treeNode5;
        treeNode31.left = treeNode6;
        treeNode5.right = treeNode7;


        String ss = solution297.serialize(null);
        System.out.println(ss);
        System.out.println(solution297.deserialize(ss));
        //TreeOperation.show(t);
    }
}

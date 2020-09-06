package xyz.nyist.arithmetic;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.Arrays;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/26 15:42
 */
public class Main1 {

    public static void main(String[] args) {
       /* int[] pre = new int[]{0, 1, 3, 7, 8, 4, 9, 2, 5, 6};
        int[] in = new int[]{7, 3, 8, 1, 9, 4, 0, 5, 2, 6};*/

        int[] pre = new int[]{1, 2, 3, 4, 5};
        int[] in = new int[]{2, 1, 4, 3, 5};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        //System.out.println(treeNode);
        TreeOperation.show(treeNode);

        //System.out.println(reConstructBinaryTree1(pre, in));
        //print(treeNode);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int r = pre[0];
        System.arraycopy(pre, 1, pre, 0, pre.length - 1);
        if (in.length == 1) {
            return new TreeNode(in[0]);
        }
        TreeNode treeNode = new TreeNode(r);
        int k = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == r) {
                k = i;
                break;
            }
        }
        int[] left = new int[k], right = new int[in.length - k - 1];
        System.arraycopy(in, 0, left, 0, k);
        System.arraycopy(in, k + 1, right, 0, in.length - k - 1);
        if (left.length > 0) {
            treeNode.left = reConstructBinaryTree(pre, left);
        }
        if (right.length > 0) {
            treeNode.right = reConstructBinaryTree(pre, right);
        }
        return treeNode;
    }

    public static TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = (reConstructBinaryTree1(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i)));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = (reConstructBinaryTree1(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length)));
                break;
            }
        }
        return root;
    }

    public static void print(TreeNode root) {
        if (root.left != null) {
            print(root.left);
        }
        if (root.right != null) {
            print(root.right);
        }
        System.out.print(root.val + " ,");

    }

}

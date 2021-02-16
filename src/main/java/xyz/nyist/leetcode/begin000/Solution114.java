package xyz.nyist.leetcode.begin000;


import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.Stack;

/**
 * @Author: silence
 * @Description: 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 *  
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/3 0:15
 */
public class Solution114 {

    public static void main(String[] args) {
        Solution114 solution114 = new Solution114();
        TreeNode root = TreeOperation.createTree("[1,2,5,3,4,null,6]");
        TreeOperation.show(root);
        solution114.flatten(root);
        TreeOperation.show(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }
            if (pre != null) {
                pre.left = null;
                pre.right = treeNode;
            }
            pre = treeNode;
        }
    }

}

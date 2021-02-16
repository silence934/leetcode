package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.Stack;

/**
 * @author fucong
 * @date 2020-07-31 19:47
 * @description 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution106 {
    public static void main(String[] args) {
        Solution106 solution106 = new Solution106();
        TreeNode treeNode = solution106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeOperation.show(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int index = postorder.length - 1;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.add(root);
        for (int i = postorder.length - 2; i > -1; i--) {
            if (!stack.isEmpty() && stack.peek().val != inorder[index]) {
                TreeNode treeNode = new TreeNode(postorder[i]);
                stack.peek().right = treeNode;
                stack.add(treeNode);
                continue;
            }
            TreeNode pre = null;
            while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                pre = stack.pop();
                index--;
            }
            TreeNode treeNode = new TreeNode(postorder[i]);
            assert pre != null;
            pre.left = treeNode;
            stack.add(treeNode);
        }
        return root;
    }
}

package xyz.nyist.leetcode.to200;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.Stack;

/**
 * @author fucong
 * @date 2020-07-28 17:10
 * @description 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution105 {
    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        TreeNode treeNode = solution105.buildTree1(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeOperation.show(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }

        System.arraycopy(preorder, 1, preorder, 0, preorder.length - 1);

        int[] inL = new int[index];
        System.arraycopy(inorder, 0, inL, 0, index);
        root.left = buildTree(preorder, inL);

        int[] inR = new int[inorder.length - index - 1];
        System.arraycopy(inorder, index + 1, inR, 0, inorder.length - index - 1);
        root.right = buildTree(preorder, inR);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) {
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        for (int i = 1; i < preorder.length; i++) {
            if (stack.peek().val != inorder[index]) {
                TreeNode treeNode = new TreeNode(preorder[i]);
                stack.peek().left = treeNode;
                stack.add(treeNode);
                continue;
            }
            TreeNode pre = null;
            while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                pre = stack.pop();
                index++;
            }
            TreeNode treeNode = new TreeNode(preorder[i]);
            assert pre != null;
            pre.right = treeNode;
            stack.add(treeNode);
        }

        return root;
    }
}

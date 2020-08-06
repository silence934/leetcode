package xyz.nyist.leetcode;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: silence
 * @Description: 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/6 23:16
 */
public class Solution145 {
    public static void main(String[] args) {
        Solution145 solution145 = new Solution145();
        System.out.println(solution145.postorderTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]")));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeOperation.show(root);
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode pre = null;
        boolean b = true;
        while (!stack.isEmpty()) {
            while (b && stack.peek().left != null) {
                stack.add(stack.peek().left);
            }
            b = false;
            TreeNode treeNode = stack.peek();
            if (treeNode.right != null && pre != treeNode.right) {
                stack.add(treeNode.right);
                b = true;
            }
            else {
                pre = treeNode;
                list.add(treeNode.val);
                stack.pop();
            }
        }

        return list;
    }
}

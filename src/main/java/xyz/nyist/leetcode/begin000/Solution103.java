package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author fucong
 * @date 2020-07-27 20:47
 * @description 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution103 {

    public static void main(String[] args) {
        Solution103 solution103 = new Solution103();
        System.out.println(solution103.zigzagLevelOrder(TreeUtil.createTree("[0,2,4,1,7,3,-1,5,1,9,6,4,8,6,2]")));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeUtil.show(root);
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        boolean b = false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty() || !stack1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (b) {
                while (!stack1.isEmpty()) {
                    TreeNode treeNode = stack1.pop();
                    list.add(treeNode.val);
                    if (treeNode.right != null) {
                        stack.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack.add(treeNode.left);
                    }
                }
                b = false;
            } else {
                while (!stack.isEmpty()) {
                    TreeNode treeNode = stack.pop();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        stack1.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack1.add(treeNode.right);
                    }
                }
                b = true;
            }
            lists.add(list);
        }
        return lists;
    }

}

package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: silence
 * @Description: 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/2 21:23
 */
public class Solution107 {
    public static void main(String[] args) {
        Solution107 solution107 = new Solution107();
        System.out.println(solution107.levelOrderBottom(TreeOperation.createTree("3,9,20,null,null,15,7")));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        TreeNode tag = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(tag);
        while (!queue.isEmpty()) {
            TreeNode t;
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty() && (t = queue.poll()).val != Integer.MAX_VALUE) {
                list.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            lists.add(0, list);
            if (!queue.isEmpty()) {
                queue.add(tag);
            }
        }
        return lists;
    }
}

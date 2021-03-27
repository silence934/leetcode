package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

/**
 * @Author: silence
 * @Description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/2 22:14
 */
public class Solution112 {
    public static void main(String[] args) {
        Solution112 solution112 = new Solution112();
        System.out.println(solution112.hasPathSum(TreeUtil.createTree("1,2"), 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        TreeUtil.show(root);
        if (root == null) {
            return false;
        }
        return test(root, 0, sum);
    }

    public boolean test(TreeNode root, int s, int sum) {
        if (root.left == null && root.right == null) {
            return s + root.val == sum;
        }
        return (root.left != null && test(root.left, s + root.val, sum)) || (root.right != null && test(root.right, s + root.val, sum));
    }
}

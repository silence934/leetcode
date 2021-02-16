package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: silence
 * @Description: 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/27 0:02
 */
public class Solution104 {
    List<Integer> list;

    public Solution104() {
        this.list = new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        System.out.println(solution104.maxDepth(null));
    }

    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return Collections.max(list);
    }

    public void maxDepth(TreeNode root, int d) {
        if (root == null) {
            list.add(d);
            return;
        }
        maxDepth(root.left, d + 1);
        maxDepth(root.right, d + 1);
    }
}

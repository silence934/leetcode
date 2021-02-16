package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: silence
 * @Description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/2 23:29
 */
public class Solution113 {
    public static void main(String[] args) {
        Solution113 solution113 = new Solution113();
        System.out.println(solution113.pathSum(TreeOperation.createTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        test1(root, 0, sum, lists, new ArrayDeque<>());
        return lists;
    }

    public void test(TreeNode root, int s, int sum, ArrayList<List<Integer>> lists, ArrayList<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (s + root.val == sum) {
                lists.add(list);
            }
        }
        if (root.left != null) {
            test(root.left, s + root.val, sum, lists, (ArrayList<Integer>) list.clone());
        }
        if (root.right != null) {
            test(root.right, s + root.val, sum, lists, (ArrayList<Integer>) list.clone());
        }
    }

    public void test1(TreeNode root, int s, int sum, ArrayList<List<Integer>> lists, ArrayDeque<Integer> list) {
        list.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (s + root.val == sum) {
                lists.add(new ArrayList<>(list));
            }
        }
        if (root.left != null) {
            test1(root.left, s + root.val, sum, lists, list);
        }
        if (root.right != null) {
            test1(root.right, s + root.val, sum, lists, list);
        }
        list.removeLast();
    }
}

package xyz.nyist.leetcode.to200;

import xyz.nyist.utils.TreeNode;

/**
 * @Author: silence
 * @Description: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/3 16:34
 */

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int index = nums.length / 2;
        TreeNode head = new TreeNode(nums[index]);
        int[] left = new int[index];
        System.arraycopy(nums, 0, left, 0, index);
        head.left = sortedArrayToBST(left);
        int[] right = new int[nums.length - index - 1];
        System.arraycopy(nums, index + 1, right, 0, nums.length - index - 1);
        head.right = sortedArrayToBST(right);
        return head;
    }


    public static void main(String[] args) {
        Solution108 solution108 = new Solution108();
        System.out.println(solution108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

}

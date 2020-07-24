package xyz.nyist.leetcode;

import xyz.nyist.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: silence
 * @Description: 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/5 15:49
 */
public class Solution199 {

    class Node {
        TreeNode treeNode;
        int index;

        public Node(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (queue.isEmpty() || queue.peek().index != node.index) {
                list.add(node.treeNode.val);
            }
            if (node.treeNode.left != null) {
                queue.add(new Node(node.treeNode.left, node.index + 1));

            }
            if (node.treeNode.right != null) {
                queue.add(new Node(node.treeNode.right, node.index + 1));

            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}

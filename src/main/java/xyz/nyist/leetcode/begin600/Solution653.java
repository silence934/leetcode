package xyz.nyist.leetcode.begin600;

import xyz.nyist.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/3/21 18:56
 * @Description:
 */
public class Solution653 {

    public boolean findTarget(TreeNode root, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            TreeNode treeNode = list.removeLast();
            map.compute(treeNode.val, (key, value) -> {
                if (value == null) {
                    return 1;
                }
                return value + 1;
            });
            if (treeNode.left != null) {
                list.addFirst(treeNode.left);
            }
            if (treeNode.right != null) {
                list.addFirst(treeNode.right);
            }
        }

        list.add(root);

        while (!list.isEmpty()) {
            TreeNode treeNode = list.removeLast();

            int exp = k - treeNode.val;

            if (map.containsKey(exp) && (exp != treeNode.val || map.get(exp) > 1)) {
                return true;
            }

            if (treeNode.left != null) {
                list.addFirst(treeNode.left);
            }
            if (treeNode.right != null) {
                list.addFirst(treeNode.right);
            }
        }


        return false;
    }

}

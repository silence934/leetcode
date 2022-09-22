package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer46 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        find(root, res, 1);

        return res;
    }


    private void find(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }
        if (depth > res.size()) {
            res.add(root.val);
        }
        find(root.right, res, depth + 1);
        find(root.left, res, depth + 1);

    }

}

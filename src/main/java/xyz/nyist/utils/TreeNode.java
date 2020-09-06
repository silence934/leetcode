package xyz.nyist.utils;

import lombok.Data;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/6/21 16:09
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

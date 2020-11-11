package xyz.nyist.utils;


/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/6/21 16:09
 */
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

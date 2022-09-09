package xyz.nyist.leetcode.lcp;

import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2022/4/27 15:37
 * @Description:
 */
public class LCP10 {

    public double minimalExecTime(TreeNode root) {
        double[] minimal = minimal(root);
        return minimal[0] - minimal[1];
    }


    public double[] minimal(TreeNode root) {
        if (root == null) {
            return new double[]{0, 0};
        }
        double[] minimal1 = minimal(root.left);
        double[] minimal2 = minimal(root.right);

        if ((minimal1[0] > minimal2[0] && minimal1[0] - 2 * minimal1[1] < minimal2[0])
                || minimal2[0] > minimal1[0] && minimal2[0] - 2 * minimal2[1] < minimal1[0]) {
            return new double[]{root.val + minimal1[0] + minimal2[0], (minimal1[0] + minimal2[0]) / 2.0};
        }

        if (minimal1[0] - 2 * minimal1[1] > minimal2[0]) {
            return new double[]{root.val + minimal1[0] + minimal2[0], minimal1[1] + minimal2[0]};
        } else {
            return new double[]{root.val + minimal1[0] + minimal2[0], minimal2[1] + minimal1[0]};
        }

    }

}

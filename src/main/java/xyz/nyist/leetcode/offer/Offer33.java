package xyz.nyist.leetcode.offer;

/**
 * @author: silence
 * @Date: 2022/12/19 14:51
 * @Description:
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }


    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int p = postorder[end];

        int mid = start;

        while (postorder[mid] < p) {
            mid++;
        }

        for (int i = mid; i < end; i++) {
            if (postorder[i] <= p) {
                return false;
            }
        }


        return verify(postorder, start, mid - 1) && verify(postorder, mid, end - 1);

    }

}

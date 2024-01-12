package xyz.nyist.leetcode.begin2000;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/16 21:51
 * @Description:
 */
public class Solution2300 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2300().successfulPairs(new int[]{5, 1, 3}, new int[]{2, 2, 2, 2, 2}, 7)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];

        for (int i = 0; i < ans.length; i++) {
            int target = (int) Math.ceil((double) success / spells[i]);

            int l = 0, r = potions.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                int k = potions[mid];
                if (k >= target && (mid == 0 || potions[mid - 1] < target)) {
                    ans[i] = potions.length - mid;
                    break;
                } else if (k < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }

        return ans;
    }
}

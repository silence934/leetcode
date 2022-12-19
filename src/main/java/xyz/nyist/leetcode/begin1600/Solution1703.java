package xyz.nyist.leetcode.begin1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/12/18 20:58
 * @Description:
 */
public class Solution1703 {
    public static void main(String[] args) {
        int[] ints = new int[50000];
        Arrays.fill(ints, 1);
        System.out.println(new Solution1703().minMoves(ints, 50000));
    }

    public int minMoves(int[] nums, int k) {

        int m = k;

        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;

        List<Integer> zero = new ArrayList<>();
        List<Integer> preSum = new ArrayList<>();

        int preOneIndex = -1;
        int cos = 0;
        while (r < nums.length) {

            while (r < nums.length && k > 0) {
                if (nums[r] == 1) {
                    if (preOneIndex != -1) {
                        int zeroNumber = r - preOneIndex - 1;
                        zero.add(zeroNumber);
                        if (preSum.size() == 0) {
                            preSum.add(zeroNumber);
                        } else {
                            preSum.add(preSum.get(preSum.size() - 1) + zeroNumber);
                        }
                    }
                    preOneIndex = r;
                    k--;
                }
                r++;
            }

            if (k > 0) {
                break;
            }


            if (cos == 0) {
                for (int i = 0; i < zero.size(); i++) {
                    cos = (zero.get(i) * Math.min(i + 1, zero.size() - i));
                }
            } else {
                int i = zero.size() - 1;
                int j = i - m + 2;
                int mid = (i + j) / 2;
                if (j > 1) {
                    cos -= (preSum.get(mid - 1) - preSum.get(j - 2));
                } else {
                    cos -= preSum.get(mid - 1);
                }

                if ((m & 1) == 1) {
                    cos += (preSum.get(i) - preSum.get(mid));
                } else {
                    cos += (preSum.get(i) - preSum.get(mid - 1));
                }
            }

            ans = Math.min(ans, cos);

            while (l < r && nums[l] == 0) {
                l++;
            }
            l++;
            k++;
        }


        return ans;
    }
}

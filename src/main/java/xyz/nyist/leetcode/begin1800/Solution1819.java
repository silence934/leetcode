package xyz.nyist.leetcode.begin1800;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2023/1/14 19:34
 * @Description:
 */
public class Solution1819 {

    public static void main(String[] args) {
        System.out.println(new Solution1819().countDifferentSubsequenceGCDs(new int[]{6, 10, 3}));
    }


    public int countDifferentSubsequenceGCDs(int[] nums) {
        Arrays.sort(nums);
        int maxVal = nums[nums.length - 1];
        int ans = 0;

        for (int i = 0; i < maxVal + 1; i++) {
            int gcd = -1;
            for (int num : nums) {
                if (num >= i) {
                    gcd = maxGcd(gcd, num);
                    if (gcd == i) {
                        ans++;
                        break;
                    }
                }
            }
        }

        return ans;
    }


    private int maxGcd(int num1, int num2) {
        if (num1 == -1) {
            return num2;
        }
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }


}

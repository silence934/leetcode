package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2022/5/11 15:31
 * @Description:
 */
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left < right) {

            int t = numbers[left] + numbers[right];
            if (t == target) {
                return new int[]{left + 1, right + 1};
            } else if (t < target) {
                left++;
            } else {
                right--;
            }
        }


        return numbers;
    }

}

package xyz.nyist.leetcode.offer;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/9/9 16:16
 * @Description: <a href="https://leetcode.cn/problems/kLl5u1/?plan=lcof&plan_progress=zqxc5y6">...</a>
 */
public class Offer6_2 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer6_2().twoSum(new int[]{1, 3, 4, 4}, 8)));
    }


    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int t2 = target - numbers[i];
            if (t2 < numbers[i]) {
                continue;
            }
            int index = findTarget(numbers, t2, i + 1, numbers.length);
            if (index != -1) {
                if (i < index) {
                    return new int[]{i, index};
                }
                return new int[]{index, i};
            }
        }

        return null;
    }


    private int findTarget(int[] numbers, int target, int start, int end) {

        if ((end == start + 1 && target != numbers[start]) || start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] > target) {
            return findTarget(numbers, target, start, mid);
        } else {
            return findTarget(numbers, target, mid + 1, end);
        }
    }

}

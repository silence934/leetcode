package xyz.nyist.asd;


import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 19:01
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                count += nums[j];
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }


}

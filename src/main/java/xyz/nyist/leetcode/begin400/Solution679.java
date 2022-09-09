package xyz.nyist.leetcode.begin400;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : silence
 * @Date: 2020-08-15 16:34
 * @Description :
 */
public class Solution679 {

    public static void main(String[] args) {
        Solution679 solution679 = new Solution679();
        System.out.println(solution679.judgePoint24(new int[]{3, 3, 8, 8}));
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> lis = new ArrayList<>();
        for (int num : nums) {
            lis.add((double) num);
        }
        return solve(lis);
    }

    private boolean solve(List<Double> numbers) {
        if (numbers.size() == 1) {
            return Math.abs(numbers.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j) {
                    double x = numbers.get(i);
                    double y = numbers.get(j);
                    List<Double> nums = new ArrayList<>();
                    for (int k = 0; k < numbers.size(); k++) {
                        if (k != i && k != j) {
                            nums.add(numbers.get(k));
                        }
                    }
                    for (Double integer : calculate(x, y)) {
                        nums.add(integer);
                        if (solve(nums)) {
                            return true;
                        }
                        nums.remove(nums.size() - 1);
                    }
                }
            }
        }

        return false;
    }

    private List<Double> calculate(double x, double y) {
        List<Double> list = new ArrayList<>();
        list.add(x + y);
        list.add(x - y);
        list.add(x * y);
        if (y != 0) {
            list.add(x / y);
        }
        return list;
    }


}

package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/3/28 10:11
 * @Description:
 */
public class Solution693 {

    public static void main(String[] args) {
        Solution693 solution693 = new Solution693();
        System.out.println(solution693.hasAlternatingBits(1431655764));
    }

    public boolean hasAlternatingBits(int n) {
        int sum = 0;
        int i;
        if ((n & 1) == 1) {
            i = 0;
        } else {
            i = 1;
        }

        for (; ; i = i + 2) {
            sum += (int) Math.pow(2, i);
            if (sum == n) {
                return true;
            } else if (sum > n || sum < 0) {
                return false;
            }
        }
    }

}

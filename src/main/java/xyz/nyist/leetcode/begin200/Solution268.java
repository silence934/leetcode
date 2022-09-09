package xyz.nyist.leetcode.begin200;

/**
 * @Author : silence
 * @Date: 2020-09-20 17:03
 * @Description :
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution268 {
    public static void main(String[] args) {
        Solution268 solution268 = new Solution268();
        System.out.println(solution268.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int m = 0;
        for (int num : nums) {
            m ^= num;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            m ^= i;
        }
        return m;
    }
}

package xyz.nyist.leetcode.to200;

import java.util.Arrays;

/**
 * @Author: silence
 * @Description: 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/23 10:41
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        int l = Math.max(a.length(), b.length()) + 1;
        byte[] as = new byte[l];
        int t = 0;
        for (int i = l - 1, x = a.length() - 1, y = b.length() - 1; i > -1; i--) {
            if (x > -1) {
                t += (a.charAt(x--) - '0');
            }
            if (y > -1) {
                t += (b.charAt(y--) - '0');
            }
            as[i] = (byte) (t % 2);
            t = t / 2;
        }
        String s = Arrays.toString(as).replaceAll(", ", "").replaceAll("]", "").replaceAll("\\[", "");
        if (s.length() > 1) {
            s = s.replaceAll("^(0)", "");
        }
        return s;
    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        System.out.println(solution67.addBinary("0", "0"));
    }
}

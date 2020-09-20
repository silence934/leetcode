package xyz.nyist.leetcode.to1600;

/**
 * @Author : fucong
 * @Date: 2020-09-20 19:28
 * @Description :
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * <p>
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * <p>
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * <p>
 * 请你返回让 s 平衡的最少插入次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()))"
 * 输出：1
 * 解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1541 {
    public static void main(String[] args) {
        Solution1541 solution1541 = new Solution1541();
        System.out.println(solution1541.minInsertions("))())("));
    }

    public int minInsertions(String s) {
        int need = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                need += 2;
                if ((need & 1) == 1) {
                    res++;
                    need--;
                }
            }
            else {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }

        return need + res;
    }
}

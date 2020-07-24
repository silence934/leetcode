package xyz.nyist.leetcode;

/**
 * @Author: silence
 * @Description: 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/21 19:13
 */
public class Solution1670 {

    /*
     *  全局变量记录a，b的值
     *  暴力破解  a=""到  a=value    b=""到b=value 相当于双重循环遍历
     *  返回true条件是pattern  value同时为空  且a  b不相同
     *
     * */

    String a = null, b = null;

    public boolean patternMatching(String pattern, String value) {
        if ("".equals(value) && (pattern.length() == 1 || "".equals(pattern))) {
            return true;
        }
        return solve(pattern, value);
    }

    public boolean solve(String pattern, String value) {
        if ("".equals(pattern) && "".equals(value)) {
            return a == null || !a.equals(b);
        }
        else if ("".equals(pattern)) {
            return false;
        }
        char s = pattern.charAt(0);
        if (s == 'a') {
            if (a == null) {
                for (int i = 0; i <= value.length(); i++) {
                    a = value.substring(0, i);
                    String t = b;
                    if (solve(pattern.substring(1), value.substring(i))) {
                        return true;
                    }
                    b = t;
                }
                return false;
            }
            else {
                for (int i = 0; i < a.length() && i < value.length(); i++) {
                    if (a.charAt(i) != value.charAt(i)) {
                        return false;
                    }
                }
                if (a.length() > value.length()) {
                    return false;
                }
                return solve(pattern.substring(1), value.substring(a.length()));
            }
        }
        else {
            if (b == null) {
                for (int i = 0; i <= value.length(); i++) {
                    b = value.substring(0, i);
                    String t = a;
                    if (solve(pattern.substring(1), value.substring(i))) {
                        return true;
                    }
                    a = t;

                }
                return false;
            }
            else {
                for (int i = 0; i < b.length() && i < value.length(); i++) {
                    if (b.charAt(i) != value.charAt(i)) {
                        return false;
                    }
                }
                if (b.length() > value.length()) {
                    return false;
                }
                return solve(pattern.substring(1), value.substring(b.length()));
            }
        }
    }


    public static void main(String[] args) {
        Solution1670 solution5 = new Solution1670();
        System.out.println(solution5.patternMatching("bbbbbbbbbbbbbbabbbbb",
                "ppppppppppppppjsftcleifftfthiehjiheyqkhjfkyfckbtwbelfcgihlrfkrwireflijkjyppppg"));
    }


}

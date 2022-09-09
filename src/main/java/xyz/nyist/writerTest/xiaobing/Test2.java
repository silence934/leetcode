package xyz.nyist.writerTest.xiaobing;

/**
 * @author: silence
 * @Date: 2022/6/1 14:29
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Test2 {

    public static void main(String[] args) {


        String[] strs = new String[]{"flower", "flow", "flight"};

        int length = 0;
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (length >= strs[i].length() || (i > 0 && strs[i].charAt(length) != strs[i - 1].charAt(length))) {
                    System.out.println(strs[i].substring(0, length));
                    return;
                }
            }
            length++;
        }


    }

}

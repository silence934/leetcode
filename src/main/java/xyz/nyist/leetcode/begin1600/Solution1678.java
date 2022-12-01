package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/30 17:47
 * @Description:
 */
public class Solution1678 {
    public String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }
}

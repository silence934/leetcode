package xyz.nyist.leetcode.begin1000;

/**
 * @author: fucong
 * @Date: 2021/7/22 19:35
 * @Description:
 */
public class Solution1156 {

    public static void main(String[] args) {
        System.out.println(new Solution1156().maxRepOpt1("acbaaa"));
    }

    public int maxRepOpt1(String text) {
        // 解决 abbaaa  case
        text = text + " ";
        int[] map = new int[128];
        for (char c : text.toCharArray()) {
            map[c]++;
        }

        int max = 1;

        int start = 0, end = 0;

        boolean exchanged = false;

        int bad = -1;

        while (end < text.length()) {

            while (end < text.length() && text.charAt(start) == text.charAt(end)) {
                end++;
            }

            //到头了
            if (end == text.length()) {
                //换过而且start->end 是全部没有别人给他换
                if (exchanged && end - start - 1 >= map[text.charAt(start)]) {
                    max = Math.max(max, end - start - 1);
                } else {
                    max = Math.max(max, end - start);
                }
            } else if (!exchanged) {
                exchanged = true;
                bad = end;
                end++;
                if (end == text.length()) {
                    //换过而且start->end 是全部没有别人给他换
                    if (end - start - 1 >= map[text.charAt(start)]) {
                        max = Math.max(max, end - start - 1);
                    } else {
                        max = Math.max(max, end - start);
                    }
                }
            } else {
                if (end - start - 1 >= map[text.charAt(start)]) {
                    max = Math.max(max, end - start - 1);
                } else {
                    max = Math.max(max, end - start);
                }
                if (end - bad > 2) {
                    start = bad + 1;
                } else {
                    start = bad;
                    end = bad;
                }
                exchanged = false;

            }

        }

        return max;
    }

}

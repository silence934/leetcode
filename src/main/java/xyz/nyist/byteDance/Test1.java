package xyz.nyist.byteDance;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 我叫王大锤，是一家出版社的编辑。我负责校对投稿来的英文稿件，这份工作非常烦人，因为每天都要去修正无数的拼写错误。但是，优秀的人总能在平凡的工作中发现真理。我发现一个发现拼写错误的捷径：
 * <p>
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 * <p>
 * 我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。用不了多久，我就会出任CEO，当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
 * ……
 * 万万没想到，我被开除了，临走时老板对我说： “做人做事要兢兢业业、勤勤恳恳、本本分分，人要是行，干一行行一行。一行行行行行；要是不行，干一行不行一行，一行不行行行不行。” 我现在整个人红红火火恍恍惚惚的……
 * <p>
 * 请听题：请实现大锤的自动校对程序
 * @Date:Create：in 2020/7/4 22:07
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(test(strs[i]));
        }
    }

    /*
    1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
    2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
    3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
    * */
    private static String test(String str) {
        char[] chars = str.toCharArray();
        for (int i = 2; i < chars.length; i++) {
            char c = chars[i];
            int k = 1, l = 3;
            while (k < l) {
                if (chars[i - k] == '#') {
                    l++;
                }
                else if (chars[i] != chars[i - k]) {
                    break;
                }
                k++;
            }
            if (k == l) {
                chars[i] = '#';
            }

            if (i > 2) {
                k = 1;
                l = 4;
                int p = 0;
                char[] temp = new char[3];
                while ((i - k) > -1 && k < l) {
                    if (chars[i - k] == '#') {
                        l++;
                    }
                    else {
                        temp[p++] = chars[i - k];
                    }
                    k++;
                }
                if (chars[i] == temp[0] && temp[1] == temp[2]) {
                    chars[i - 1] = '#';
                }
            }
        }
        return new String(chars).replaceAll("#", "");
    }
}

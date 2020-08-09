package xyz.nyist.asd.meiTuan;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 外卖节即将过去了，小美还有很代金券没有消费掉，美团面向小美这样的用户推出了一个新的活动，即代金券消消乐活动。系统会把小美的代金券打乱顺序排成一排，小美可以进行任意多次如下操作：
 * <p>
 * 如果存在相邻的两个代金券金额相等,设其面额为x，小美可以使用这两张代金券换一张面额为x+1的代金券，并将其仍放在原来两张券的位置上，每进行一次这样的操作，小美就可以获得1元可以无限期使用的奖励金。
 * <p>
 * 小美觉得奖励金可太香了，因此她想获得尽可能多的奖励金，请问她最多可以获得多少奖励金。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入第一行仅包含一个正整数n，表示小美拥有的代金券数量。(1<=n<=500)
 * <p>
 * 输入第二行包含n个正整数，每个整数x表示一张代金券的面额，同时这也是系统排出的代金券顺序。(1<=x<=100)
 * <p>
 * 输出描述
 * 输出仅包含一个整数，表示小美最多可以获得的奖励金数量。
 * <p>
 * <p>
 * 样例输入
 * 5
 * 1 1 1 1 1
 * 样例输出
 * 3
 * <p>
 * 提示
 * 样例解释：
 * {1,1,1,1,1}->{1,1,1,2}->{1,2,2}->{1,3}
 * @Date:Create：in 2020/8/8 16:47
 */
public class Test4 {

    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        test(p, 0);
        System.out.println(res);
    }

    public static void test(int[] p, int start) {
        int end = 0;
        for (int i = start; i < p.length; i++) {
            if (i != start && p[i] != p[i - 1]) {
                end = i;
                break;
            }
        }
        if (end == 0) {
            end = p.length;
        }
        if (end <= start) {
            return;
        }
        int t = p[start];
        int s = (end - start) / 2;
        res += s;
        for (int i = end - s; i < end; i++) {
            p[i] = t;
        }
        test(p, end - s);
    }
}

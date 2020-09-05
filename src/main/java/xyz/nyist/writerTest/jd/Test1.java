package xyz.nyist.writerTest.jd;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2020-08-27 18:56
 * @Description :
 * 自从学了素数以后，小明喜欢上了数字2、3和5。当然，如果一个数字里面只出现2、3和5这三个数字，他也一样喜欢，例如222、2355、223355。
 * <p>
 * 现在他希望你能够帮他编写一个程序，快速计算出由2、3、5这三个数字组成的由小到大的第n个数，当然也包括2、3和5。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 单组输入。
 * <p>
 * 每组输入数据占1行，每行输入一个正整数n。（n<=1000）
 * <p>
 * 输出描述
 * 每组输出数据占1行，即满足要求的第n个数。
 * <p>
 * <p>
 * 样例输入
 * 3
 * 样例输出
 * 5
 */
public class Test1 {
    public static void main(String[] args) {
        //2 3 5
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //几位数
        int sum = 0, k = 0;
        while (sum < n) {
            int y = (int) Math.pow(3, ++k);
            sum += y;
        }
        //第几个
        int t = n - (sum - ((int) Math.pow(3, k)));
        //共几个
        int m = (int) Math.pow(3, k);
        while (k-- > 0) {
            if (t <= m / 3) {
                System.out.print(2);
            }
            else if (t <= m / 3 * 2) {
                System.out.print(3);
                t -= m / 3;
            }
            else {
                System.out.print(5);
                t -= m / 3 * 2;
            }
            m /= 3;
        }
    }
}

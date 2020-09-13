package xyz.nyist.writerTest.meituan;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 美团对于商家的评价体系是1-5星评价体系，用户在完成订单之后可以对商家打1/2/3/4/5星，而在客户端上，商家的评级却不一定是整数，而是会显示小数点后的一位。很显然这就需要一个计算器了，小美拥有了一些商户的评价数据，希望可以计算出商家在客户端上显示出的评分。
 * <p>
 * 这个评分的计算非常简单，就是对该商家的所有客户的星级评价做求一个平均，然后去尾法显示小数点后的一位即可，例如平均得分是3.55，则显示的是3.5。例如某商家获得了1-5星评价各一个，则显示的评分是(1+2+3+4+5)/5=3.0。
 * <p>
 * 如果商家没有获得评价，则显示0.0。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入包含5个整数，依次分别表示商家获得1星到5星的评价数量，每一种评价的数量都不大于1000。
 * <p>
 * 输出描述
 * 输出仅包含一个保留一位的小数，表示商家在客户端上显示的评级。
 * <p>
 * <p>
 * 样例输入
 * 2 2 1 1 2
 * 样例输出
 * 2.8
 * @Date:Create：in 2020/8/8 15:54
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, t = 0;
        for (int i = 0; i < 5; i++) {
            int f = scanner.nextInt();
            sum += f * (i + 1);
            t += f;
        }
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(1);
        format.setGroupingSize(0);
        format.setRoundingMode(RoundingMode.FLOOR);
        if (t == 0) {
            System.out.println("0.0");
        }
        else {
            if (sum % t != 0) {
                double d = sum / (double) t;
                System.out.println(format.format(d));
            }
            else {
                System.out.println(sum / t + ".0");
            }
        }
    }
}

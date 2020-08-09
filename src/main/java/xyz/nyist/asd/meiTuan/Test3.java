package xyz.nyist.asd.meiTuan;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 小美是美团的一名鲜花快递员，鲜花是一种保质期非常短的商品，所以需要尽快送到客户手中，公司对于骑手的一个要求就是要规划送花的线路，使得骑手送完所有订单走的路程尽可能少。(骑手开始派送时带走了所有需要派送的花，不必每单后返回花店，路程结算是从花店出发，到送完最后一名客户为止，不计算从最后一名客户家回到花店的时间)
 * <p>
 * 公司对于骑手的绩效评价是取决于两个指标，一是从花店到所有客户地址的距离之和，另一个是骑手实际走的路程。
 * <p>
 * 设花店始终位于1号位置，客户共有n-1个，其编号为2~n。令dis(i,j)表示i号位置到j号位置的距离，即分别计算 , 和骑手实际所走的最短路程。
 * <p>
 * 为了简化问题，我们约束这n个位置构成的是一棵树，即只有n-1条边在其中互相连接，且保证n个点彼此连通。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输出第一行包含一个正整数n，即花店和客户的总数。(1<=n<=30000)
 * <p>
 * 接下来有n-1行，每行有三个整数u,v,w，表示在u和v之间存在一条距离为w的道路。(1<=w<=1000)
 * <p>
 * 输出描述
 * 输出包含两个整数，中间用空格隔开，分别表示花店到所有客户地址的距离之和和骑手实际走的路程。
 * <p>
 * <p>
 * 样例输入
 * 5
 * 1 2 3
 * 1 3 1
 * 1 4 2
 * 2 5 1
 * 样例输出
 * 10 10
 * @Date:Create：in 2020/8/8 16:30
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] path = new int[n + 1];
        int sum1 = 0, sum2 = 0;
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            sum2 += z;
            if (x == 1) {
                path[y] = z;
            }
            else {
                path[y] = path[x] + z;
            }
            sum1 += path[y];
            max = Math.max(max, path[y]);
        }
        System.out.println(sum1 + " " + ((sum2 - max) * 2 + max));
    }
}

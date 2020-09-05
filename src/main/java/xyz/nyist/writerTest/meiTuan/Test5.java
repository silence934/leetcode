package xyz.nyist.writerTest.meiTuan;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 小团作为一名美团骑手，最喜欢的颜色就是黄和黑，因此对包含这两种颜色的事物都格外留意。
 * <p>
 * 这天他发现有一棵树，树上的每个节点都是黄的或者黑的。现在小团想知道对于这棵树中的每个节点，在以其为根的子树中，所有与其颜色不同的节点的深度之和是多少。子树中节点的深度被定义为该节点与该子树根节点之间的最短路径的边数。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行有一个数n，代表这棵树上一共有n个节点，编号为1~n。(1<n<=100000)
 * <p>
 * 第二行有n个数，第i个数表示编号为i的节点的颜色，为0表示黄色，为1表示黑色。
 * <p>
 * 第三行有n-1个数，第i个数表示编号为i+1的节点的父节点编号。
 * <p>
 * 输出描述
 * 在一行中输出n个数，第i个数代表第i个节点的答案。
 * <p>
 * <p>
 * 样例输入
 * 10
 * 0 0 1 0 0 1 1 1 0 0
 * 1 2 3 4 4 5 7 6 9
 * 样例输出
 * 17 13 10 6 3 3 0 0 0 0
 * @Date:Create：in 2020/8/8 17:31
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i][0] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            p[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                int k = 0;
                if (p[i][0] != p[j][0]) {
                    int t = j;
                    while (t != i) {
                        if (t == 0) {
                            k=0;
                            break;
                        }
                        t = p[t][1] - 1;
                        k++;
                    }
                }
                s += k;
            }
            System.out.print(s + " ");
        }
    }

}

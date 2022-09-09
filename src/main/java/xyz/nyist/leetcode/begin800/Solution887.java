package xyz.nyist.leetcode.begin800;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author : silence
 * @Date: 2020-09-06 18:12
 * @Description :你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution887 {

    private static Map<Node, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Solution887 solution887 = new Solution887();
        System.out.println(solution887.superEggDrop1(4, 100));
    }

    public int superEggDrop(int K, int N) {

        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }

        if (memo.containsKey(new Node(K, N))) {
            return memo.get(new Node(K, N));
        }

        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(
                    superEggDrop(K - 1, i - 1),
                    superEggDrop(K, N - i)) + 1);
        }

        memo.put(new Node(K, N), res);

        return res;
    }

    private static class Node {

        int k;

        int n;

        public Node(int k, int n) {
            this.k = k;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return k == node.k &&
                    n == node.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, n);
        }

    }

    public int superEggDrop1(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int i = 1; i < K + 1; i++) {
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }
        return m;
    }

}

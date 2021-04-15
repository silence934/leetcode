package xyz.nyist.leetcode.begin400;

import java.util.*;

/**
 * @Author: silence
 * @Description: 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/freedom-trail
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/12 18:01
 */

public class Solution514 {

    static Map<Character, List<Integer>> mp;
    static int[][] dp;

    public static int findRotateSteps2(String ring, String key) {
        int rl = ring.length();
        int kl = key.length();
        if (kl == 0) {
            return 0;
        }
        char[] r = ring.toCharArray();
        char[] k = key.toCharArray();
        mp = new HashMap<>();
        for (int i = 0; i < rl; i++) {//保存字符出现的位置
            if (mp.containsKey(r[i])) {
                mp.get(r[i]).add(i);
            } else {
                List<Integer> next = new ArrayList<>();
                next.add(i);
                mp.put(r[i], next);
            }
        }
        dp = new int[kl][rl];
        List<Integer> next2 = mp.get(k[0]);
        Iterator<Integer> it2 = next2.iterator();
        while (it2.hasNext()) {
            int c = it2.next();
            int m = Math.min(c, rl - c);//找到每个位置
            dp[0][c] = m + 1;
        }
        for (int i = 1; i < kl; i++) {

            List<Integer> next = mp.get(k[i]);
            Iterator<Integer> it = next.iterator();
            while (it.hasNext()) {
                int c = it.next();//找到本次的所有位置
                int min = Integer.MAX_VALUE;
                List<Integer> next1 = mp.get(k[i - 1]);
                Iterator<Integer> it1 = next1.iterator();
                while (it1.hasNext()) {
                    int d = it1.next();//找到上个字符所有的位置来计算
                    int m = Math.min(rl - c + d, rl - d + c);
                    m = Math.min(m, Math.abs(c - d));
                    min = Math.min(min, dp[i - 1][d] + m + 1);

                }
                dp[i][c] = min;
            }
        }
        int ans = Integer.MAX_VALUE;
        List<Integer> next = mp.get(k[kl - 1]);
        Iterator<Integer> it = next.iterator();
        while (it.hasNext()) {
            ans = Math.min(ans, dp[kl - 1][it.next()]);
        }
        return ans;


    }


    public static int findRotateSteps1(String ring, String key) {
        List<Integer> list = new ArrayList<>();
        char[] r = ring.toCharArray();
        char[] k = key.toCharArray();
        getLength(0, r, k, 0, 0, list);
        System.out.println(list);
        return key.length() + Collections.min(list);
    }

    public static void getLength(int point, char[] r, char[] k, int i, int l, List<Integer> list) {
        if (i == k.length) {
            list.add(l);
            return;
        }
        for (int j = point; j < r.length; j++) {
            if (k[i] == r[j]) {
                getLength(j, r, k, i + 1, l + j - point, list);
            }
        }
        if (point > 0) {
            for (int j = point; j > -1; j--) {
                if (k[i] == r[i]) {
                    getLength(j, r, k, i + 1, l + point - j, list);
                }
            }
        }
       /* for (int j = 0; j < r.length; j++) {
            if (r[j] == k[i]) {
                getLength(j, r, k, i + 1, l + getShort(r.length, point, j), list);
            }
        }*/
    }

    public static int getShort(int l, int point, int target) {
        int d = Math.abs(target - point);
        return Math.min(d, l - d);
    }

    public static void main(String[] args) {
        System.out.println(findRotateSteps2("caotmcaataijjxi"
                , "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }

    public static int findRotateSteps(String ring, String key) {
        char[] r = ring.toCharArray();
        char[] k = key.toCharArray();
        int l = 0;
        for (char c : k) {
            int head = 0, end = 0;
            for (int i = 0; i < r.length; i++) {
                if (c == r[i]) {
                    head = i;
                    break;
                }
            }
            for (int i = r.length - 1; i > -1; i--) {
                if (c == r[i]) {
                    end = r.length - i;
                    break;
                }
            }
            if (head < end) {
                //顺时针
                l += head;
                char[] t = r.clone();
                System.arraycopy(t, head, r, 0, r.length - head);
                System.arraycopy(t, 0, r, r.length - head, head);
            } else {
                //逆时针
                l += end;
                char[] t = r.clone();
                System.arraycopy(t, r.length - end, r, 0, end);
                System.arraycopy(t, 0, r, end, r.length - end);
            }
            l++;
        }
        return l;
    }
}

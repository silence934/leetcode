package xyz.nyist.writerTest.wangyi;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/9/12 15:28
 */
public class Main2 {

    static int la = 0, lb = 0, lc = 0, lx = 0, ly = 0, lz = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        int total = chars.length;

        for (char c : chars) {
            if (c == 'a') {
                la++;
            }
            if (c == 'b') {
                lb++;
            }
            if (c == 'c') {
                lc++;
            }
            if (c == 'x') {
                lx++;
            }
            if (c == 'y') {
                ly++;
            }
            if (c == 'z') {
                lz++;
            }
        }

        if (chars.length == 1) {
            if (getL(chars[0]) == -1) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
            return;
        }

        int start = 0, end = total - 1;
        while (!test() && start < end) {
            char sta = chars[start], en = chars[end];
            int l = getL(sta), r = getL(en);

            if (l == -1 && r == -1) {
                start++;
                end--;
            }
            else if (sta == en) {
                start++;
                end--;
                desc(sta);
                desc(en);
            }
            else if (l != -1 && is(l) && r != -1 && !is(r)) {
                end--;
                desc(en);
            }
            else if (r != -1 && is(r) && l != -1 && !is(l)) {
                start++;
                desc(sta);
            }
            else if (r != -1 && l != -1 && !is(l) && !is(r)) {
                start++;
                end--;
                desc(sta);
                desc(en);
            }
            else if (r == -1 && is(l)) {
                end--;
                desc(en);
            }
            else if (l == -1 && is(r)) {
                start++;
                desc(sta);
            }
            else if (r == -1 && !is(l)) {
                start++;
                desc(sta);
            }
            else if (l == -1 && !is(r)) {
                end--;
                desc(en);

            }
            else {
                System.out.println("xxxx");
            }
        }

        System.out.println(end - start + 1);
    }

    private static int getL(char c) {
        if (c == 'a') {
            return la;
        }
        else if (c == 'b') {
            return lb;
        }
        else if (c == 'c') {
            return lc;
        }
        else if (c == 'x') {
            return lx;
        }
        else if (c == 'y') {
            return ly;
        }
        else if (c == 'z') {
            return lz;
        }
        else {
            return -1;
        }
    }

    private static void desc(char c) {
        if (c == 'a') {
            la--;
        }
        else if (c == 'b') {
            lb--;
        }
        else if (c == 'c') {
            lc--;
        }
        else if (c == 'x') {
            lx--;
        }
        else if (c == 'y') {
            ly--;
        }
        else if (c == 'z') {
            lz--;
        }
    }

    private static boolean test() {
        return is(la) && is(lb) && is(lc) && is(lx) && is(ly) && is(lz);
    }

    private static boolean is(int k) {
        return (k & 1) == 0;
    }
}

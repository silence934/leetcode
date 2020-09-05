package xyz.nyist.writerTest.simaite;


import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 19:01
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s1 = in.nextLine().toCharArray();
        char[] s2 = in.nextLine().toCharArray();
        for (int i = 0; i < s2.length; i++) {
            if (s2[i] == s1[0]) {
                char[] t = new char[s2.length - i];
                System.arraycopy(s2, i, t, 0, t.length);
                test(s1, t, i, 0);
            }
        }

    }

    public static void test(char[] s1, char[] s2, int start, int l) {
        if (s1.length == 0 || s2.length == 0) {
            return;
        }
        if (s1[0] == s2[0]) {
            if (s1.length == 1) {
                System.out.println(start + " " + (l + 1));
            }
            else {
                char[] t1 = new char[s1.length - 1];
                System.arraycopy(s1, 1, t1, 0, t1.length);
                char[] t2 = new char[s2.length - 1];
                System.arraycopy(s2, 1, t2, 0, t2.length);
                test(t1, t2, start, l + 1);
            }
        }
        else if (s1[0] == '*') {
            char[] t1 = new char[s1.length - 1];
            System.arraycopy(s1, 1, t1, 0, t1.length);
            char[] t2 = new char[s2.length - 1];
            System.arraycopy(s2, 1, t2, 0, t2.length);
            test(s1, t2, start, l + 1);
            test(t1, s2, start, l);
        }
    }


}

package xyz.nyist.writerTest.simaite;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 19:01
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);
        System.out.println(n1.multiply(n2));
    }
}

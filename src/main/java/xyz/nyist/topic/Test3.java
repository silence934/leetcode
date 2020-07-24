package xyz.nyist.topic;


import java.math.BigInteger;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger count = new BigInteger("0");
        for (int i = n & 1; i <= n; i += 2) {
            int t = i + (n - i) / 2;
            count = count.add(factorial(i + 1, t).divide(factorial(1, t - i)));
        }
        System.out.println(count);
    }

    private static BigInteger factorial(int start, int end) {
        BigInteger res = new BigInteger("1");
        for (int i = start; i <= end; i++) {
            res = res.multiply(new BigInteger("" + i));
        }
        return res;
    }
}

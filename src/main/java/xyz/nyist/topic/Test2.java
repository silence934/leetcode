package xyz.nyist.topic;


import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long count = 0L;
        if (k == 0) {
            count = (long) n * (long) n;
        }
        else {
            for (int y = k + 1; y <= n; y++) {
                count += n / y * (y - k) + Math.max(0, n % y - k + 1);
            }
        }
        System.out.println(count);
    }
}

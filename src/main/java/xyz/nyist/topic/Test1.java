package xyz.nyist.topic;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] s = scanner.next().substring(0, n).toCharArray();
        int start = 1;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'L') {
                start--;
            }
            else if (s[i] == 'R') {
                start++;
            }
        }
        switch (start % 4) {
            case 0:
                System.out.println("W");
                break;
            case 1:
            case -3:
                System.out.println("N");
                break;
            case 2:
            case -2:
                System.out.println("E");
                break;
            case 3:
            case -1:
                System.out.println("S");
                break;
        }
    }
}

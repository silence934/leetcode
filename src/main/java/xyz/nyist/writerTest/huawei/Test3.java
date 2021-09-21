package xyz.nyist.writerTest.huawei;

import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2021/9/21 20:48
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = new char[]{'1', '2', '3', '4', '5', '6'};
        for (char c : sc.nextLine().toCharArray()) {
            change(chars, c);
        }
        System.out.println(new String(chars));
    }


    private static void change(char[] chars, char c) {
        //0 左  1 右  2 前 3 后 4上 5下
        switch (c) {
            case 'L': {
                char t = chars[0];
                chars[0] = chars[4];
                chars[4] = chars[1];
                chars[1] = chars[5];
                chars[5] = t;
                break;
            }
            case 'R': {
                char t = chars[0];
                chars[0] = chars[5];
                chars[5] = chars[1];
                chars[1] = chars[4];
                chars[4] = t;
                break;
            }
            case 'F': {
                char t = chars[2];
                chars[2] = chars[4];
                chars[4] = chars[3];
                chars[3] = chars[5];
                chars[5] = t;
                break;
            }
            case 'B': {
                char t = chars[2];
                chars[2] = chars[5];
                chars[5] = chars[3];
                chars[3] = chars[4];
                chars[4] = t;
                break;
            }
            case 'A': {
                char t = chars[0];
                chars[0] = chars[3];
                chars[3] = chars[1];
                chars[1] = chars[2];
                chars[2] = t;
                break;
            }
            case 'C': {
                char t = chars[0];
                chars[0] = chars[2];
                chars[2] = chars[1];
                chars[1] = chars[3];
                chars[3] = t;
                break;
            }
            default:
        }
    }


}

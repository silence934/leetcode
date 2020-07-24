package xyz.nyist.leetcode;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 1.判断字符串是否形如“192.168.1.1”
 * <p>
 * 2.字符串两端含有空格视为合法ip，形如“    192.168.1.1    ”
 * <p>
 * 3.字符串中间含有空格视为非法ip，形如“192.168. 1.2”
 * <p>
 * 4.字符串0开头视为不合法ip，形如192.168.01.1
 * <p>
 * 5.字符串0.0.0.0视为合法ip
 * @Date:Create：in 2020/6/21 21:59
 */
public class Test1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine().trim();
        System.out.println(testIp(ip));
        
    }

    private static boolean testIp(String ip) {
        String[] item = ip.split("\\.");
        if (item.length != 4) {
            return false;
        }
        if ("0.0.0.0".equals(ip)) {
            return true;
        }
        for (String s : item) {
            char[] temp = s.toCharArray();
            int number;
            try {
                number = Integer.parseInt(s);
                if (!(number > -1 && number < 255)) {

                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
            if (temp.length == 1 && temp[0] == 0) {
                return false;
            }

        }
        return true;
    }


}

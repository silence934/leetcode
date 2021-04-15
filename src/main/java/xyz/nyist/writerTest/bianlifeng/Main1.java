package xyz.nyist.writerTest.bianlifeng;

import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2021/4/9 17:15
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(test(str));
    }


    private static String test(String str) {
        if (str.equals("")) {
            return "";
        }
        char s = str.charAt(0);

        String res = "";

        if (s == '{') {
            int i = 1, t = 1;
            while (i < str.length()) {
                if (str.charAt(i) == '}') {
                    t--;
                } else if (str.charAt(i) == '{') {
                    t++;
                }
                if (t == 0) {
                    break;
                }
                i++;
            }
            if (i == str.length()) {
                res = test(str.substring(1, i));
            } else {
                res = test(str.substring(1, i)) + test(str.substring(i + 1));
            }

        } else if (s >= 'A' && s <= 'Z') {
            int i = 1;
            while (i < str.length() && str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                i++;
            }
            if (i == str.length()) {
                res = str;
            } else {
                res = str.substring(0, i) + test(str.substring(i));
            }
        } else if (s >= '0' && s <= '9') {
            int i = 1;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                i++;
            }
            if (i == str.length()) {
                res = str;
            } else {
                int k = Integer.parseInt(str.substring(0, i));
                String temp, end;
                if (str.charAt(i) == '{') {
                    int y = i + 1, t = 1;
                    while (y < str.length()) {
                        if (str.charAt(y) == '}') {
                            t--;
                        } else if (str.charAt(y) == '{') {
                            t++;
                        }
                        if (t == 0) {
                            break;
                        }
                        y++;
                    }
                    if (y == str.length()) {
                        temp = test(str.substring(i + 1, y));
                        end = "";
                    } else {
                        temp = test(str.substring(i + 1, y));
                        end = test(str.substring(y + 1));
                    }

                } else {
                    temp = test(str.substring(i));
                    end = "";
                }

                for (int j = 0; j < k; j++) {
                    res += temp;
                }
                res += end;
            }
        }


        return res;
    }

}

package xyz.nyist.writerTest.quna;

import java.util.*;

/**
 * @author: silence
 * @Date: 2021/4/12 18:33
 * @Description:
 */
public class Main2 {

    static List<String> getAll(int length, int start, int end, String input) {
        String str = input.substring(start, end);
        String[] split = input.split(str);
        String pre, suf;
        if (start == 0 && end == length) {
            pre = "";
            suf = "";
        } else if (start == 0) {
            pre = "";
            suf = split[0];
        } else if (end == 0) {
            pre = split[0];
            suf = "";
        } else {
            pre = split[0];
            suf = split[1];
        }

        List<String> res = new ArrayList<>();
        for (String s : getAll(str.toUpperCase())) {
            res.add(pre + s + suf);
        }
        return res;
    }

    static List<String> getAll(String str) {
        if (str.length() == 2) {
            return Arrays.asList(
                    str,
                    str.charAt(0) + str.substring(1).toLowerCase(),
                    str.substring(0, 1).toLowerCase() + str.charAt(1),
                    str.substring(0, 1).toLowerCase() + str.substring(1).toLowerCase()
            );
        } else {
            List<String> all = getAll(str.substring(1));
            List<String> res = new ArrayList<>();
            String aCase = "" + str.charAt(0);
            for (String s : all) {
                res.add(aCase + s);
            }
            aCase = str.substring(0, 1).toLowerCase();
            for (String s : all) {
                res.add(aCase + s);
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();

        int endIndexOfLength = line.indexOf(' ');
        int length = Integer.parseInt(line.substring(0, endIndexOfLength));

        int endIndexOfStart = line.indexOf(' ', endIndexOfLength + 1);
        int start = Integer.parseInt(line.substring(endIndexOfLength + 1, endIndexOfStart));

        int endIndexOfEnd = line.indexOf(' ', endIndexOfStart + 1);
        int end = Integer.parseInt(line.substring(endIndexOfStart + 1, endIndexOfEnd));

        String input = line.substring(endIndexOfEnd + 1);

        List<String> result = getAll(length, start, end, input);
        Collections.sort(result);
        for (int i = 0; i < result.size(); ++i) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.println(result.get(i));
            }
        }
        System.out.flush();
    }
}

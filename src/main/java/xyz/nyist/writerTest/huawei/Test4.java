package xyz.nyist.writerTest.huawei;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/5/23 18:39
 * @Description:
 */
public class Test4 {

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        System.out.println(test4.test("/asd/"));
        System.out.println(test4.test("/../"));
        System.out.println(test4.test("/asd/www/"));
        System.out.println(test4.test("/a/./b/../../c/"));
        System.out.println(test4.test("/a/../../b/../c//.//"));
        System.out.println(test4.test("/a//b/////c/d//././/.."));
    }


    private String test(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        LinkedList<String> list = new LinkedList<>();

        String[] split = str.split("/");
        for (String s : split) {
            if (s != null && !"".equals(s)) {
                if (".".equals(s)) {

                } else if ("..".equals(s)) {
                    if (!list.isEmpty()) {
                        list.removeLast();
                    }
                } else {
                    list.addLast(s);
                }
            }
        }

        StringBuilder sb = new StringBuilder("/");
        for (String s : list) {
            sb.append(s).append("/");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

}

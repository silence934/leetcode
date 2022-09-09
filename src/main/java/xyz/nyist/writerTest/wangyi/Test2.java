package xyz.nyist.writerTest.wangyi;

/**
 * @Author : silence
 * @Date: 2020-09-11 19:33
 * @Description :
 * <p>
 * "a0cbAAAdc0ad"
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String s = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBeeeeeeeeeeFYHHnjHAPQQc";
        System.out.println(s.length());
        System.out.println(test2.compress(s));
        System.out.println("0ZB0tB0geFYHHnjHAPQQc");
    }

    public String test(int i) {
        if (i < 30) {
            return (char) (i + 93) + "";
        }
        else {
            return (char) (i + 35) + "";
        }
    }

    public String compress(String raw) {
        if (raw == null || "".equals(raw)) {
            return "";
        }
        char[] chars = raw.toCharArray();
        int start = 0, end = 1;
        while (chars.length - start > 3) {
            char k = chars[start];
            while (end < chars.length && chars[end] == k && end - start < 55) {
                end++;
            }
            if (end - start < 4) {
                start = end;
                end++;
            }
            else {
                String t = new String(chars);
                String s = t.substring(0, start) + "0" + test(end - start) + k + t.substring(end);
                chars = s.toCharArray();
                start = start + 3;
                end = start + 1;
            }
        }
        return new String(chars);
    }


}

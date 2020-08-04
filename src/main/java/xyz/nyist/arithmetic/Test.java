package xyz.nyist.arithmetic;

/**
 * @author fucong
 * @date 2020-07-31 15:16
 * @description
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String s = "2000000";
        String[] units = new String[]{"", "拾", "百", "千", "万", "亿", "兆", "京", "垓", "秭", "穰", "沟", "涧", "正", "载"};
        int index = 0, k = 4;
        char[] sa = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for (int i = sa.length - 1; i > -1; i--) {
            if (t++ > 3 && index == k) {
                if (t != 5) {
                    k++;
                }
                index = 0;
                char c = sa[i];
                if (c == '0') {
                    index++;
                    sb.append(units[k]);
                }
                else {
                    sb.append(units[k]).append(units[index++]).append(transition(c));
                }
            }
            else {
                char c = sa[i];
                if (c == '0') {
                    index++;
                    sb.append(c);
                }
                else {
                    sb.append(units[index++]).append(c);
                }
            }
        }
        System.out.println(sb.toString());
        char[] a = sb.toString().toCharArray();
        for (int i = 0; i < a.length; i++) {
        }
        System.out.println(sb.reverse().toString());
    }

    public static String transition(char c) {
        switch (c) {
            case '1':
                return "一";
            case '2':
                return "二";
            case '3':
                return "三";
            case '4':
                return "四";
            case '5':
                return "五";
            case '6':
                return "六";
            case '7':
                return "七";
            case '8':
                return "八";
            case '9':
                return "九";
            case '0':
                return "零";
            default:
                return "";
        }
    }

}

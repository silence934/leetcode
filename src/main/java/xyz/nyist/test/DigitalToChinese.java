package xyz.nyist.test;

/**
 * @author silence
 * @date 2020-07-31 15:16
 * @description 数字转中文
 */
public class DigitalToChinese {

    public static void main(String[] args) throws Exception {
        String s = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
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
                } else {
                    sb.append(units[k]).append(units[index++]).append(transition(c));
                }
            } else {
                char c = sa[i];
                if (c == '0') {
                    index++;
                    sb.append(c);
                } else {
                    sb.append(units[index++]).append(c);
                }
            }
        }
        char[] a = sb.toString().toCharArray();
        for (int i = 1; i < a.length; i++) {
            if (a[i] == '0' && a[i - 1] == '0') {
                a[i] = '#';
            }
        }
        String str = new String(a);
        a = str.replaceAll("#", "").toCharArray();
        boolean b = true;
        for (int i = 0; i < a.length; i++) {
            if (b) {
                if (a[i] == '0') {
                    a[i] = '#';
                    continue;
                } else {
                    b = false;
                }
            }
            if (isNumber(a[i])) {
                if (a[i] == '0') {
                    if (i < a.length - 1 && !isNumber(a[i - 1]) && !isNumber(a[i + 1])) {
                        a[i] = '#';
                    } else {
                        a[i] = transition(a[i]);
                    }
                } else {
                    a[i] = transition(a[i]);
                }
            }
        }

        str = new String(a);
        sb = new StringBuilder(str.replaceAll("#", ""));
        System.out.println(sb.reverse().toString());
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static char transition(char c) {
        switch (c) {
            case '1':
                return '一';
            case '2':
                return '二';
            case '3':
                return '三';
            case '4':
                return '四';
            case '5':
                return '五';
            case '6':
                return '六';
            case '7':
                return '七';
            case '8':
                return '八';
            case '9':
                return '九';
            case '0':
                return '零';
            default:
                return ' ';
        }
    }

}

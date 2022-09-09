package xyz.nyist.leetcode.offer;

/**
 * @author: silence
 * @Date: 2022/9/8 17:28
 * @Description:
 */
public class Offer2_2 {

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int al = a.length() - 1;
        int bl = b.length() - 1;


        boolean fig = false;
        while (al > -1 || bl > -1) {

            char m = al > -1 ? a.charAt(al) : '0';
            char n = bl > -1 ? b.charAt(bl) : '0';

            if (m == '1' && n == '1') {
                if (fig) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                fig = true;
            } else if (m == '1' || n == '1') {
                if (fig) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            } else if (fig) {
                sb.append('1');
                fig = false;
            } else {
                sb.append('0');
            }

            al--;
            bl--;
        }
        if (fig) {
            sb.append('1');
        }


        return sb.reverse().toString();
    }

}

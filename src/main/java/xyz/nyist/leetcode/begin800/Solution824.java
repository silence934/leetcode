package xyz.nyist.leetcode.begin800;

/**
 * @author: silence
 * @Date: 2022/4/21 21:24
 * @Description:
 */
public class Solution824 {

    public static void main(String[] args) {
        Solution824 solution824 = new Solution824();
        System.out.println(solution824.toGoatLatin("i"));
    }

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();

        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            char first = str.charAt(0);
            if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'
                    || first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U') {
                sb.append(str).append("ma");
            } else {
                sb.append(str.substring(1)).append(first).append("ma");
            }

            for (int j = 0; j <= i; j++) {
                System.out.println("123");
                sb.append("a");
            }
            sb.append(" ");
        }

        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }

        return sb.toString();
    }
}

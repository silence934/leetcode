package xyz.nyist.writerTest.sougou;

/**
 * @Author : silence
 * @Date: 2020-09-25 19:21
 * @Description :
 */
public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        //["1101","1010","1111","1110"],["ABCD","EFGH","IJKL","MNPQ"]
        System.out.println(test2.rotatePassword(new String[]{"1101", "1010", "1111", "1110"}, new String[]{"ABCD", "EFGH", "IJKL", "MNPQ"}));
        System.out.println("CFHQGLMPAIKNBDEJ");
    }

    public String rotatePassword(String[] s1, String[] s2) {
        char[][] chars1 = test(s1);
        char[][] chars2 = test(s2);
        StringBuilder sb = new StringBuilder();
        sb.append(compare(chars1, chars2));
        chars1 = converter(chars1);
        sb.append(compare(chars1, chars2));
        chars1 = converter(chars1);
        sb.append(compare(chars1, chars2));
        chars1 = converter(chars1);
        sb.append(compare(chars1, chars2));
        return sb.toString();
    }

    private char[][] converter(char[][] s1) {
        int n = s1.length;
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = s1[i][j];
            }
        }
        return res;
    }

    private String compare(char[][] chars1, char[][] chars2) {
        StringBuilder sb = new StringBuilder();
        int n = chars1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chars1[i][j] == '0') {
                    sb.append(chars2[i][j]);
                }
            }
        }
        return sb.toString();
    }

    private char[][] test(String[] strings) {
        int n = strings.length;
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            res[i] = strings[i].toCharArray();
        }
        return res;
    }

    private void print(char[][] s1) {
        for (char[] chars : s1) {
            for (int j = 0; j < s1.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

}

package xyz.nyist.leetcode.begin1400;

/**
 * @author: silence
 * @Date: 2022/9/7 16:43
 * @Description:
 */
public class Solution1592 {

    public String reorderSpaces(String text) {
        int number = 0;
        int word = 0;
        char[] chars = text.toCharArray();

        boolean preIsEmpty = true;
        for (char aChar : chars) {
            if (aChar == ' ') {
                number++;
                preIsEmpty = true;
            } else if (preIsEmpty) {
                word++;
                preIsEmpty = false;
            }
        }


        int spaces = word != 1 ? number / word - 1 : 0;
        int residue = number - (word - 1) * spaces;

        System.out.println(number + " " + word + " " + spaces + " " + residue);

        StringBuilder strSpaceBuilder = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            strSpaceBuilder.append(" ");
        }
        String strSpace = strSpaceBuilder.toString();

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                sb.append(chars[i]);
                if (word > 1 && chars[i + 1] == ' ') {
                    word--;
                    sb.append(strSpace);
                }
            }
        }
        for (int i = 0; i < residue; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

}

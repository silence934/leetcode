package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer34 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[128];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i)] = i;
        }

        for (int i = 1; i < words.length; i++) {
            int index = 0;
            while (true) {
                if (words[i - 1].length() <= index) {
                    break;
                } else if (words[i].length() <= index) {
                    return false;
                }
                int a = map[words[i].charAt(index)];
                int b = map[words[i - 1].charAt(index)];
                if (a < b) {
                    return false;
                } else if (a > b) {
                    break;
                }
                index++;
            }
        }


        return true;
    }

}

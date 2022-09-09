package xyz.nyist.leetcode.offer;

/**
 * @author: silence
 * @Date: 2022/9/9 16:16
 * @Description: <a href="https://leetcode.cn/problems/aseY1I/?envType=study-plan&id=lcof-ii">...</a>
 */
public class Offer5_2 {

    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= (1 << c - 'a');
            }
            masks[i] = mask;
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }

}

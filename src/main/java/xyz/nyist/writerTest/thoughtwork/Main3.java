package xyz.nyist.writerTest.thoughtwork;

/**
 * @Author : fucong
 * @Date: 2021-01-10 17:35
 * @Description :
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(countRepetition("asasa",
                "asa"));

    }

    public static int countRepetition(String speech, String word) {
        int res = 0;

        int start = 0;
        int end = word.length() - 1;
        int t = 0;
        while (start < end) {
            if (word.charAt(start++) == word.charAt(end--)) {
                t++;
            } else {
                break;
            }
        }

        int l = word.length() - t;
        int k;
        while ((k = speech.indexOf(word)) != -1) {
            res++;
            speech = speech.substring(k + l);
        }
        return res;
    }


}

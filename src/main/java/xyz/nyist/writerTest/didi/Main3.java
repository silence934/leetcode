package xyz.nyist.writerTest.didi;

/**
 * @author: silence
 * @Date: 2021/8/14 10:50
 * @Description: m*n 数组   左上角 -》 右下角
 * <p>
 * 数组   2 3 1 7 1  左往右遍历数组      2 3 1 1 7
 */
public class Main3 {

    public static void main(String[] args) {

        int k = 0;

        int[] numbers = new int[]{2, 3, 1, 7, 1};


        for (int i = 0; i < numbers.length - k; i++) {
            if (numbers[i] == 1) {
                k++;
                numbers[i] = -1;
            }
        }
        

    }

}

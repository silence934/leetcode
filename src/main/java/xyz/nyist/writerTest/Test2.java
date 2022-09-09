package xyz.nyist.writerTest;

/**
 * @Author : silence
 * @Date: 2020-11-08 13:24
 * @Description :
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(poorPigs(1000, 20, 60));
    }


    static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int count = minutesToTest / minutesToDie + 1;  //能测试几次
        int sum = 1;              //猪的数量
        int num = count;          //总共测试几个了
        while (num < buckets) {
            num *= count;
            sum++;
        }

        return sum;

    }

}

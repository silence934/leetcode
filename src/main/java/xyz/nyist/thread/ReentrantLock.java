package xyz.nyist.thread;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/5/18 17:33
 */
public class ReentrantLock {
    public static void main(String[] args) {
        ReentrantLock.test1();
    }

    private synchronized static void test1() {
        test2();
    }

    private synchronized static void test2() {
        System.out.println("2222222");
    }
}

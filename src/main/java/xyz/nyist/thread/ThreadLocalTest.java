package xyz.nyist.thread;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/6/7 20:29
 */
public class ThreadLocalTest {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    String str;


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalTest test = new ThreadLocalTest();
        for (int i = 0; i < 5000; i++) {
            Thread t = new Thread(() -> {
                //test.setStr(Thread.currentThread().getName());
                threadLocal.set(Thread.currentThread().getName());

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!Thread.currentThread().getName().equals(threadLocal.get())) {
                    System.out.println("ssssss");
                }
                /*threadLocal.set(student);
                System.out.println(threadLocal.get());
                threadLocal.remove();*/
            });
            t.setName("" + i);
            t.start();
        }
    }
}

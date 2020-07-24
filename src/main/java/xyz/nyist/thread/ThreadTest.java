package xyz.nyist.thread;

import java.io.IOException;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/18 20:33
 */
public class ThreadTest {
    public static void main(String[] args) throws IOException {
        System.out.println("进入线程" + Thread.currentThread().getName());
        Thread thread1 = new MyThread("线程1");
        Thread thread2 = new MyThread("线程2");
        thread1.start();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "等待");
            thread1.join(3000);

            //thread1.interrupt();
            // thread2.start();
            System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {

        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            try {
                for (int i = 0; i < 500; i++) {
                    System.out.println(i);
                    Thread.sleep(500);
                    if (isInterrupted()) {
                        break;
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
        }
    }
}

package xyz.nyist.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/21 16:10
 */
public class TaskQueue {

    Queue<String> queue = new LinkedList<>();

    public void addTask(String s, Object o) {
        synchronized (o) {
            this.queue.add(s);
            o.notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTask(Object o) throws InterruptedException {
        synchronized (o) {
            while (queue.isEmpty()) {
                o.wait();
            }
            return queue.element();
        }
    }

    /*private static void aa() throws InterruptedException {
        TaskQueue q = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                // 执行task:
                try {
                    System.out.println("execute task: " + q.getTask());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        });
        add.start();
        add.join();
    }*/

    private static void bb() {
        Object o = new Object();
        Object o1 = new Object();
        TaskQueue q = new TaskQueue();
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(q.getTask(o));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println(q.getTask(o));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            q.addTask("sssssssssss", o);
        });
        thread1.start();
        thread3.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        //aa();
        bb();
    }

}

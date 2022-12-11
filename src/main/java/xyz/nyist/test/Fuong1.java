package xyz.nyist.test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: silence
 * @Date: 2022/12/8 15:46
 * @Description:
 */
public class Fuong1 {
    public static void main(String[] args) {
        Fuong1 fuong1 = new Fuong1();
        fuong1.client();
    }


    private void client() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 3; i++) {
            Future<Integer> future = executor.submit(this::call);
            try {
                future.get(3, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("请求失败(非超时问题)");
                executor.shutdown();
                break;
            } catch (TimeoutException e) {
                System.out.printf("第%d次请求超时%n", i + 1);
                future.cancel(true);
                continue;
            }
            System.out.println("succeeded");
            executor.shutdown();
            return;
        }
        executor.shutdown();
        System.out.println("failed");
    }


    private int call() {
        Random random = new Random();
        int time = random.nextInt(5);
        try {
            //随机0-5s返回
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        return 0;
    }


}

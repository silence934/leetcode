package xyz.nyist.test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/21 15:00
 */
public class Data {
    private String packet;

    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }

    public static class Sender implements Runnable {
        private Data data;

        public Sender(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            String[] packets = {"First packet", "Second packet", "Third packet", "Fourth packet", "End"};

            for (String packet : packets) {
                data.send(packet);

                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Receiver implements Runnable {
        private Data load;

        public Receiver(Data load) {
            this.load = load;
        }

        @Override
        public void run() {
            for (String receivedMessage = load.receive(); !"End".equals(receivedMessage); receivedMessage = load.receive()) {
                System.out.println(receivedMessage);
            }
        }
    }

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}

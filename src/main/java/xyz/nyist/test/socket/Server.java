package xyz.nyist.test.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/8/5 21:55
 */
public class Server {
    public static final String TAG = "bye";
    public static final Integer PORT = 10200;


    public Server() {
        PrintWriter out = null;
        try {
            ServerSocket ss = new ServerSocket(PORT);
            Socket socket = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String line;
            while (!TAG.equals(line = in.readLine())) {
                System.out.println("收到消息" + line);
                out.println("已收到:" + line);
            }
            out.close();
            in.close();
            socket.close();
            System.out.println("断开连接!");
        } catch (IOException e) {
            e.printStackTrace();
            if (out != null) {
                out.print("错误:" + e);
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }


}

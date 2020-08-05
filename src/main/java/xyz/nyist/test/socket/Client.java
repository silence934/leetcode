package xyz.nyist.test.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/8/5 21:56
 */
public class Client {

    public Client() {
        PrintWriter out = null;
        try {
            Socket socket = new Socket("127.0.0.1", Server.PORT);
            System.out.println("连接成功!");
            System.out.println("请输入:");
            BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String msg;
            while (!Server.TAG.equals(msg = line.readLine())) {
                out.println(msg);
                System.out.println(in.readLine());
            }
            out.close();
            in.close();
            socket.close();
            System.out.println("关闭连接");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            if (out != null) {
                out.println("错误:" + e);
            }
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client();

    }
}

package com.pger.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) {
        server1();
    }

    /**
     * 同步阻塞IO
     * JDK1.4之前，java.io...，java.net
     *
     */
    private static void server1() {
        ServerSocket server = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        int port = 8080;
        try {
            server = new ServerSocket(port);
            System.out.printf("----服务端启动成功，监听端口为 " + port + "，等待客户端连接...\n");
            socket = server.accept();// 阻塞IO
            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) > 0) {
                System.out.printf(new String(buffer, 0, len));
            }
            // 向客户端写数据
            os = socket.getOutputStream();
            os.write("hello gupao".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void server2() {
        ServerSocket server = null;
        int port = 8080;
        try {
            server = new ServerSocket(port);
            System.out.printf("----服务端启动成功，监听端口为 " + port + "，等待客户端连接...\n");

            while (true) {
                Socket socket = server.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        } catch (Exception e) {

        }
    }

    static class ServerHandler implements Runnable {
        private Socket socket;
        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) > 0) {
                    System.out.printf(new String(buffer, 0, len));
                }
                // 向客户端写数据
                os = socket.getOutputStream();
                os.write("hello gupao".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void server3() {
        ServerSocket server = null;
        int port = 8080;
        ExecutorService service = Executors.newFixedThreadPool(60);
        try {
            server = new ServerSocket(port);
            System.out.printf("----服务端启动成功，监听端口为 " + port + "，等待客户端连接...\n");

            while (true) {
                Socket socket = server.accept();
                service.execute(new ServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

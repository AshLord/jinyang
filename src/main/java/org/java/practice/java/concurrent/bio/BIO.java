package org.java.practice.java.concurrent.bio;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yang.jin
 * date: 28/12/2017
 * desc:
 */
public class BIO {

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8888));
        //主线程死循环等待新连接到来
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            executor.submit(new ConnectIOnHandler(socket));
        }
    }

    static class ConnectIOnHandler extends Thread {

        private Socket socket;

        public ConnectIOnHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted() &&
                    socket.isClosed()) {
                try {
                    // 读数据
                    String content = IOUtils.toString(socket.getInputStream());
                    if (content != null) {
                        // 模拟数据处理过程
                        Thread.sleep(3000);
                        // 写数据
                        socket.getOutputStream().write(content.getBytes());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

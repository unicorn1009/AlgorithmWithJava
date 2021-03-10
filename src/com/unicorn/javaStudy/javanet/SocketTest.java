package com.unicorn.javaStudy.javanet;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <p>
 *     Socket 是一个抽象概念，负责启动应用程序内部和外部之间的通信
 * </p>
 * Created on 2021/3/6.
 *
 *
 * @author Unicorn
 */


public class SocketTest {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("localhost");   // IP地址
            socket = new Socket(inetAddress, 1818);      // 构建Socket
            outputStream = socket.getOutputStream();          // 获取输出流
            outputStream.write("hello ,你好啊小辣鸡".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() throws IOException {
        // 服务端使用ServerSocket构建Socket， 指明自己的端口号
        ServerSocket serverSocket = new ServerSocket(1818);
        // 调用accept方法表示接受来自于客户端的socket
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[20];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            String msg = new String(buffer, 0, len);
            System.out.print(msg);
        }

        // 关闭资源
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}

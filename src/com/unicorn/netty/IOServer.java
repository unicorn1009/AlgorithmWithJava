package com.unicorn.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 * </p>
 * Created on 2021/3/7.
 *
 * @author Unicorn
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        new Thread(()->{
            System.out.println("111111111111111111");
            while (true){
                System.out.println("2222222222222222222");
                try {
                    // 1. 阻塞方法等待客户端的连接
                    Socket socket = serverSocket.accept();

                    // 2. 每当有一个客户端连接进来后，就启动一个单独的线程进行处理
                    new Thread(()->{
                        try {
                            // 3. 字节流方式读取数据
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while ((len = inputStream.read(data)) != -1){
                                System.out.println(new String(data,0,len));
                            }
                            System.out.println("333333333333333333333333");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

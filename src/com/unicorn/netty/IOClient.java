package com.unicorn.netty;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * <p>
 * </p>
 * Created on 2021/3/7.
 *
 * @author Unicorn
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true){
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }
}

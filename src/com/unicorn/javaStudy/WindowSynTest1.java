package com.unicorn.javaStudy;

import java.util.Random;

/**
 * <p>
 *     解决线程安全问题方式二: 同步方法 synchronized
 * </p>
 * Created on 2021-01-20.
 *
 * @author Unicorn
 */
public class WindowSynTest1 {
    public static void main(String[] args) {
        Window3 window = new Window3();

        Thread w1 = new Thread(window);
        Thread w2 = new Thread(window);
        Thread w3 = new Thread(window);

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window3 implements Runnable {

    // 此处无static
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 卖出 1 张票, 剩余 " + (--ticket) + " 张");

        }
    }
}
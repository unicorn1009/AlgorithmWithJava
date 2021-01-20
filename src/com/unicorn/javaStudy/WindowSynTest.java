package com.unicorn.javaStudy;

import java.util.Random;

/**
 * <p>
 *     解决线程安全问题方式一: 同步代码块 synchronized
 * </p>
 * Created on 2021-01-20.
 *
 * @author Unicorn
 */
public class WindowSynTest {
    public static void main(String[] args) {

        Window2 window = new Window2();

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

class Window2 implements Runnable{

    // 此处无static
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            // 括号里为锁(同步监视器),可以为任意对象,要求锁唯一
            synchronized (this) {
                int subTicket = random.nextInt(5)+1;
                if (ticket >= subTicket) {
                    ticket -= subTicket;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    System.out.println(Thread.currentThread().getName() + " 卖出"+subTicket+"张票, 剩余 " + (ticket) + " 张");

                } else if (ticket > 0) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}

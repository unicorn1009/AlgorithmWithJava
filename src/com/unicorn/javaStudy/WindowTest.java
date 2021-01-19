package com.unicorn.javaStudy;

/**
 * <p>
 *     三个窗口卖100张票: 使用继承Thread类的方式
 *     存在线程安全问题
 * </p>
 * Created on 2021-01-19.
 *
 * @author Unicorn
 */
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }

}

class Window extends Thread{
    public static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+" 卖出一张票, 剩余 "+(--ticket)+" 张");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                break;
            }
        }
    }
}

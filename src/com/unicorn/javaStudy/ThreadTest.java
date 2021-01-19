package com.unicorn.javaStudy;

/**
 * <p>
 *     创建多线程 - 方式一:继承Thread类
 *
 *     Thread.currentThread(): 获取当前执行的线程
 *     getName(): 获取当前线程的名称
 *     setName(): 设置当前线程的名称
 *     yield(): 释放cpu的执行权
 *     join(): 在线程A中调用线程B的join方法,会使A线程进入阻塞状态, 知道B线程执行完为止
 *     sleep(long millis): 让当前线程睡眠指定的毫秒数
 *
 * </p>
 *
 * Created on 2021-01-19.
 *
 * @author Unicorn
 */
public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        // 方法一: 创建子类对象,执行start方法
        MyThread t1 = new MyThread();
        t1.start(); // 1. 启用子线程, 2. 调用run()方法运行于子线程中

        // 方法二: 创建Thread类的匿名子类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2 != 0) {
                        try {
                            sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("***********"+Thread.currentThread().getName()+"***********"+i);
                    }
                }
            }
        }.start();

        for (int i = 0; i < 200; i++) {
            if (i%2 != 0)
                System.out.println("***********"+Thread.currentThread().getName()+"***********"+i);
        }
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            if (i%2 == 0)
                System.out.println("***********"+Thread.currentThread().getName()+"***********"+i);
        }
    }
}
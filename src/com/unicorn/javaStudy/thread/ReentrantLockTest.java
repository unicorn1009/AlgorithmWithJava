package com.unicorn.javaStudy.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * </p>
 * Created on 2021/6/13.
 *
 * @author Unicorn
 */
public class ReentrantLockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                reentrantLock.lockInterruptibly();
                while (true) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " : 我睡了");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : 被打断");
                // 打断后的处理
            } finally {
                reentrantLock.unlock();
            }
        }, "t1");
        t1.start();

//        Thread t2 = new Thread(() -> {
//            try {
//                reentrantLock.lockInterruptibly();
//                while (true) {
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName() + " : 我睡了");
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println(Thread.currentThread().getName() + " : 被打断");
//            } finally {
//                reentrantLock.unlock();
//            }
//        }, "t2");
//        t2.start();

        Thread.sleep(1000);
        System.out.println("开始打断");
        t1.interrupt();
//
//        Thread.sleep(1000);
//        System.out.println("开始打断");
//        t1.interrupt();

    }
}

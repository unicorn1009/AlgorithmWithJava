package com.unicorn.大厂热题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *     t1, t2, t3 三个线程交替输出
 * </p>
 * Created on 2021-8-2.
 *
 * @author Unicorn
 */
public class 多线程交替输出 {
    public static void main(String[] args) {
        // 推荐使用方法三，最简单
        method3();
    }

    // 方法一
    public static void method1(){
        WaitNotify waitNotify = new WaitNotify(1, 5);
        new Thread(()->waitNotify.print("hello1", 1, 2),"t1").start();
        new Thread(()->waitNotify.print("hello2", 2, 3),"t2").start();
        new Thread(()->waitNotify.print("hello3", 3, 1),"t3").start();
    }

    // 方法二
    public static void method2(){
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition t1 = awaitSignal.newCondition();
        Condition t2 = awaitSignal.newCondition();
        Condition t3 = awaitSignal.newCondition();
        new Thread(()->awaitSignal.print("hello1", t1, t2), "t1").start();
        new Thread(()->awaitSignal.print("hello2", t2, t3), "t2").start();
        new Thread(()->awaitSignal.print("hello3", t3, t1), "t3").start();
        awaitSignal.lock();
        try {
            t1.signal();
        } finally {
            awaitSignal.unlock();
        }
    }

    // 方法三
    static Thread t1;
    static Thread t2;
    static Thread t3;
    public static void method3(){
        ParkUnpark parkUnpark = new ParkUnpark(5);
        t1 = new Thread(() -> parkUnpark.print("hello1", t2));
        t2 = new Thread(() -> parkUnpark.print("hello2", t3));
        t3 = new Thread(() -> parkUnpark.print("hello3", t1));
        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t1);

    }
}


// 第一种方法， 使用Wait() NotifyAll()
class WaitNotify{

    private int flag;
    private int loopNumber;

    public void print(String str, int flag, int nextFlag){
        for (int i = 0; i < this.loopNumber; i++) {
            synchronized (this){
                while (this.flag != flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + str);
                this.flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}


// 方法二 ： 使用ReentrantLock的Await 和 Signal
class AwaitSignal extends ReentrantLock{
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String str, Condition current, Condition next){
        for (int i = 0; i < this.loopNumber; i++) {
            this.lock();
            try {
                // 一上来先进阻塞队列
                current.await();
                System.out.println(Thread.currentThread().getName() + " : " + str);
                // 打印完，唤醒下一个
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }
}

// 方法三 ： 使用Park Unpark
class ParkUnpark{
    private int loopNumber;

    public void print(String str, Thread next){
        for (int i = 0; i < this.loopNumber; i++) {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " : " + str);
            LockSupport.unpark(next);
        }
    }

    public ParkUnpark(int loopNumber) {
        this.loopNumber = loopNumber;
    }
}

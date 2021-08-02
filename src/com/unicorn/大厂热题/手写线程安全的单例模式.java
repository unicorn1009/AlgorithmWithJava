package com.unicorn.大厂热题;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * </p>
 * Created on 2021-7-28.
 *
 * @author Unicorn
 */
public class 手写线程安全的单例模式 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }

    }



}

class SingletonDemo{

    private static volatile SingletonDemo instance = null;


    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + " : "+ "SingletonDemo()");
    };

    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

}

package com.unicorn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 * Created on 2021/5/31.
 *
 * @author Unicorn
 */
public class Solution0001 {
    public static void main(String[] args) throws InterruptedException {
        Solution0001 solution0001 = new Solution0001();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 40; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        solution0001.m1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        Thread.sleep(1000);
        System.out.println("=============");
        for (int i = 0; i < 40; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        solution0001.m1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void m1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+":我是任务");
        Thread.sleep(100);
    }





}

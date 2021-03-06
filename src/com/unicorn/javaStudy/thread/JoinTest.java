package com.unicorn.javaStudy.thread;

import org.junit.jupiter.api.Test;

/**
 * <p>
 * </p>
 * Created on 2021/2/19.
 *
 * @author Unicorn
 */
public class JoinTest {
    static int r = 0;

    @Test
    public void test1(){
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = 10;
        }, "t1");
        t1.start();
        // 不会等待线程t1结束, 就取到了r值
        System.out.println(r);  // 0
        // join方法会等待线程结束
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(r);  // 10
        System.out.println("结束");
    }

    @Test
    public void test2(){
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = 10;
        }, "t1");
        t1.start();
        // 不会等待线程t1结束, 就取到了r值
        System.out.println(r);  // 0
        // join的参数表示最多等待时间
        try {
            t1.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(r);  // 0
        System.out.println("结束");

    }
}

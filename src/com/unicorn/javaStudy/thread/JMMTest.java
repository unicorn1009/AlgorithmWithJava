package com.unicorn.javaStudy.thread;

/**
 * <p>
 * </p>
 * Created on 2021/6/13.
 *
 * @author Unicorn
 */
public class JMMTest {

    // volatile : 易变
    volatile static boolean run = true;

    public static void main(String[] args) {
        new Thread(()->{
            while (run){
//                System.out.println(" ");
            }
        }).start();


        try {
            Thread.sleep(1000);
            run = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

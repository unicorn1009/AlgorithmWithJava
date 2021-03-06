package com.unicorn.javaStudy.thread;

/**
 * <p>
 *     懒汉单例模式改进 - 改为线程安全
 * </p>
 * Created on 2021-01-25.
 *
 * @author Unicorn
 */
public class LHSingleton {

}

class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){

        // 方式一 : 效率稍低
//        synchronized (Bank.class){
//            if (instance == null)
//                instance = new Bank();
//
//            return instance;
//        }

        // 方式二: 效率更高, 建议使用
        if (instance == null){
            synchronized (Bank.class){
                if (instance == null)
                    instance = new Bank();
            }
        }
        return instance;
    }
}

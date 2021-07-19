package com.unicorn.mianshijindian;

import java.util.ArrayList;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-06-18 11:17 下午
 */
public class MS019 {
    public static void main(String[] args) {
        ThreadSafe threadSubClass = new ThreadSafe();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                threadSubClass.method1();
            }, "T" + i).start();
        }
    }

}

class ThreadSafe {
    ArrayList<String> list = new ArrayList<>();


    public void method1() {
        for (int i = 0; i < 200; i++) {
            list.add("1");
            new Thread(()->{
                list.remove(0);
            },"T100").start();
//            method3(list);
        }
    }

    public void method2(ArrayList<String> list) {
        list.add("1");
    }

    public void method3(ArrayList<String> list) {
        System.out.println(1);
        list.remove(0);
    }
}

class ThreadSubClass extends ThreadSafe {

    public void method3(ArrayList<String> list) {
        new Thread(() -> {
            System.out.println(list.size());
            list.remove(0);
        }, "T3").start();
    }
}

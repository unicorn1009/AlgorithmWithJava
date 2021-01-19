package com.unicorn.javaStudy;

/**
 * <p>
 *     创建多线程 - 方式二 : 继承Runnable接口
 *     1. 创建一个实现了Runnable接口的类
 *     2. 实现类中需要实现Runnable中的抽象方法:run()方法
 *     3. 创建该实现类的对象
 *     4. 将此对象作为参数传递到Thread类的构造器中, 从而创建出一个Thread类的对象
 *     5. 通过Thread类的对象调用start()
 *
 * </p>
 * Created on 2021-01-19.
 *
 * @author Unicorn
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();

        Thread t1 = new Thread(thread);
        t1.start();

        Thread t2 = new Thread(thread);
        t2.start();


        for (int i = 0; i < 200; i++) {
            if (i%2 != 0)
                System.out.println("***********"+Thread.currentThread().getName()+"***********"+i);
        }

    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            if (i%2 == 0)
                System.out.println("***********"+Thread.currentThread().getName()+"***********"+i);
        }
    }
}

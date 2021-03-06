package com.unicorn.javaStudy.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *     创建多线程方式四 : 线程池
 * </p>
 * Created on 2021-01-25.
 *
 * @author Unicorn
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 创建指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 分配线程执行任务
        service.execute(new MyThread4());   // execute方法适用于Runnable
        service.execute(new MyThread4());
//        service.submit()                  // submit方法适用于Callable
        // 关闭线程池
        service.shutdown();

    }
}

class MyThread4 implements Runnable{

    @Override
    public void run() {
        // 操作: 计算0-100内所有偶数和,并返回
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}

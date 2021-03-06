package com.unicorn.javaStudy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>
 *     创建多线程方式三 : 实现Callable接口, 配合FutureTask -- jdk5.0新增
 *     优点 : 可返回结果
 *
 * </p>
 *
 * Created on 2021-01-25.
 *
 * @author Unicorn
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread3 t1 = new MyThread3();
        FutureTask futureTask = new FutureTask(t1);
        FutureTask futureTask1 = new FutureTask(t1);
        // 启动线程
        new Thread(futureTask).start();
        new Thread(futureTask1).start();
        try {
            // FutureTask的get()方法的返回值即为FutureTask的构造器中传入的Callable实现类的call方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和:"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 使用Callable匿名实现类来简化, <Integer>泛型参数即为返回值类型
        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "  AAA");
                return 1+2;
            }
        });
        new Thread(ft).start();
        // 阻塞等待结果
        Integer r = ft.get();
        System.out.println(r);
    }
}

class MyThread3 implements Callable{

    @Override
    public Object call() throws Exception {
        // 操作: 计算0-100内所有偶数和,并返回
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum+=i;
            }
        }
        return sum;
    }
}

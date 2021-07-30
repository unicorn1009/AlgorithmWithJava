package com.unicorn.大厂热题;

import java.util.HashSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p>
 * </p>
 * Created on 2021-7-29.
 *
 * @author Unicorn
 */
public class 手撕线程池 {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 5);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是任务");
                }
            });
        }
    }
}

class ThreadPool{

    // 核心线程数
    private int coreSize;

    // 阻塞队列(任务集合)
    private BlockingDeque<Runnable> taskQueue;

    private int queueCapacity;

    // 线程集合
    private HashSet<Worker> workers;

    private long timeout;

    public ThreadPool(int coreSize, int queueCapacity) {
        this.coreSize = coreSize;
        this.taskQueue = new LinkedBlockingDeque<>(queueCapacity);
        this.queueCapacity = queueCapacity;
        this.workers = new HashSet<>();
    }


    // 执行任务
    public void execute(Runnable task){
        synchronized (workers) {
            // 1. 判断当前线程数是否等于coreSize
            if (workers.size() < coreSize){
                // 若小于, 则创建新线程执行任务
                Worker worker = new Worker(task);
                worker.start();
                // worker 加入线程集合
                workers.add(worker);
            }else{
                // 若等于,则放入阻塞队列
                // 情况一: 阻塞队列不满, 直接添加
                if (taskQueue.size() < queueCapacity) {
                    System.out.println("加入任务队列");
                    taskQueue.add(task);
                }
                else {
                    System.out.println("任务被抛弃...");
                }
                // 情况二: 阻塞队列满, 拒绝策略(啥也不做)

            }
        }
    }

    class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            // 执行任务
            // task 任务执行完毕后, 从任务队列中取出任务执行

            while (task != null || !taskQueue.isEmpty()){
                try {
                    if (task == null)
                        task = taskQueue.take();
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }
            // 任务队列中没有任务, 则销毁当前worker
            synchronized (workers) {
                workers.remove(this);
            }
        }
    }
}
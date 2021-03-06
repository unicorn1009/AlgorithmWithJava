package com.unicorn.javaStudy.thread;

/**
 * <p>
 *     线程的interrupt方法 , 可替代线程的stop方法
 * </p>
 * Created on 2021/2/19.
 *
 * @author Unicorn
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
//        test2();
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        Thread.sleep(4500);
        twoPhaseTermination.stop();

    }

    public static void test1(){
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(1);
            }
        }, "t1");
        t1.start();
        t1.interrupt();
        System.out.println("t1被打断, 但不能决定线程是否终止");
    }

    public static void test2(){
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(1);
                // 可以使用打断标识来判断是否被打断
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted){
                    System.out.println("我被打断了");
                    break;
                }
            }
        }, "t1");
        t1.start();
        t1.interrupt();
        System.out.println("t1被打断, 但不能决定线程是否终止");
    }
}

// 两阶段终止模式(使用interrupt代替stop保证线程安全)
class TwoPhaseTermination{
    private Thread thread;

    public void start(){
        thread = new Thread(()->{
            while (true){
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()){
                    System.out.println("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);     // 情况1, 此处被打断会重设打断标记为false, 因此需要在catch中设置打断标记
                    System.out.println("执行操作"); // 情况2 , 正常执行被打断, 打断标记为true
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    thread.interrupt();
                }
            }
        });
        thread.start();
    }

    public void stop(){
        if (thread != null){
            thread.interrupt();
        }
    }
}

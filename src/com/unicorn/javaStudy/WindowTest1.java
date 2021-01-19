package com.unicorn.javaStudy;

/**
 * <p>
 *      三个窗口卖100张票: 使用实现Runnable接口的方式
 *      仍然存在线程安全问题
 * </p>
 * Created on 2021-01-19.
 *
 * @author Unicorn
 */
public class WindowTest1 {
    public static void main(String[] args) {

        Window1 window = new Window1();

        Thread w1 = new Thread(window);
        Thread w2 = new Thread(window);
        Thread w3 = new Thread(window);

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}

class Window1 implements Runnable{

    // 此处无static
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+" 卖出一张票, 剩余 "+(--ticket)+" 张");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                break;
            }
        }
    }
}

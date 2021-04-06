package com.unicorn.jvm;

/**
 * <p>
 * </p>
 * Created on 2021/04/06 16:11
 *
 * @author Unicorn
 */
public class Test1 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer();

        for (int i = 0; i < 100; i++) {
            a.append(1);
        }
        new Thread(()->{
            m1(a);
        }).start();
        System.out.println(a.toString());
    }

    public static void m1(StringBuffer sb){
        for (int i = 0; i < 100; i++) {
            sb.append(2);
        }
        System.out.println(sb.toString());
    }
}

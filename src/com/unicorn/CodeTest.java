package com.unicorn;


import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * </p>
 * Created on 2021/2/18.
 *
 * @author Unicorn
 */
public class CodeTest {

    public AtomicInteger count;

    public static void main(String[] args) {
        CodeTest codeTest = new CodeTest();
        codeTest.count = new AtomicInteger(0);
        codeTest.m();
        System.out.println(codeTest.count);
    }

    public void m(){
        new Thread(()->{
            for (int i = 0; i < 200000; i++) {
                m1();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                m2();
            }
        }).start();
    }

    public void m1(){
        count.getAndIncrement();
    }

    public void m2(){
        count.getAndDecrement();
    }

}

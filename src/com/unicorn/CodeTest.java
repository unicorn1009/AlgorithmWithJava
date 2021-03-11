package com.unicorn;


import org.junit.jupiter.api.Test;

/**
 * <p>
 * </p>
 * Created on 2021/2/18.
 *
 * @author Unicorn
 */
public class CodeTest {
    public static void main(String[] args) {
    }


    @Test
    public void test(){
        int i = 1;
        i = i++;        // i = 1
        int j = i++;    // j = 1 , i =2
        int k = i+++i*i++;  //      2+3*3
        System.out.println(i);  // 4
        System.out.println(j);  // 1
        System.out.println(k);  // 11
    }

    public static void test1(){
        String a = "abc";
        String b = "bbb" + 2 + 1 + 2 + a;
        System.out.println(b);
    }

    @Test
    public void test2(){
        int i = 1;
        System.out.println(i+(++i));
    }
}

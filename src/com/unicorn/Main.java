package com.unicorn;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger num;

    public static void main(String[] args) {

        num = new AtomicInteger(1);
        num.getAndIncrement();

        Integer a = -129;
        Integer b = -129;
        System.out.println(a==b);
        // System.out.println(Test.i);
    }

    @org.junit.jupiter.api.Test
    public void test01(){
        List<Integer> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        System.out.println(arr1.getClass() == arr2.getClass());
    }

    @org.junit.jupiter.api.Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    public void test03(){
        String a = "abc";
        m1(a);
        System.out.println(a);
    }

    public void m1(String s){
        s = s + "def";
    }

}

class Test{

    static int i=1;
    static
    {
        i=0;
    }
}

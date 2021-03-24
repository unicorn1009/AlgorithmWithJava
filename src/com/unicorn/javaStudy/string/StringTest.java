package com.unicorn.javaStudy.string;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * <p>
 *     String的使用
 * </p>
 * Created on 2021-01-25.
 *
 * @author Unicorn
 */
public class StringTest {

    private String name;

    public static void main(String[] args) {

        String s1 = "abc"; // 字面量的定义方式
        String s2 = "abc"; // 此时s2和s1的地址实际上是一样的, 这是因为通过字面量的方式定义的字符串存储在字符串常量池中, 池中不会存储两个相同的常量
        System.out.println(s1 == s2); // true
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s3 == s4);   // false, 此时s3和s4的地址就不一样了, 因为new出来的对象都在堆里
        System.out.println(s1 == s3);   // false
        String s5 = "aaa", s6="bbb";

    }

    @Test
    public void test5(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "a"+"b";
        String s4 = s1+s2;
        String s5 = "ab";
        String s6 = s4.intern();

        System.out.println(s3 == s4);   // false
        System.out.println(s3 == s5);   // true
        System.out.println(s3 == s6);   // true

        System.out.println(s4 == "ab");

    }

    @Test
    public void test6(){
        String s1 = new String("a") + new String("b");
        System.out.println(s1 == "ab"); // false
        String s2 = s1.intern();
        System.out.println(s1 == "ab"); // false
        System.out.println(s2 == "ab"); // true
    }

    // 对比test6
    @Test
    public void test7(){
        String s1 = new String("a") + new String("b");
//        System.out.println(s1 == "ab");
        String s2 = s1.intern();
        System.out.println(s1 == "ab"); // true
        System.out.println(s2 == "ab"); // true
    }

    @Test
    public void test4(){
        Byte[] arr = new Byte[10];
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "我爱你";
        byte[] bytes = s1.getBytes("gbk");
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes,"gbk"));
    }

    @Test
    public void test2(){
        Person person = new Person("小明", 16, 100);
        System.out.println(person);
        change(person);
        System.out.println(person);
    }

    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";
        String s4 = "abc" + "def";
        String s5 = s1 + "def";
        String s6 = s1 + s2;
        System.out.println(s3 == s4);   // true
        System.out.println(s3 == s5);   // false
        System.out.println(s3 == s6);   // false
        System.out.println("*******************************");
        char[] s7 = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(s3.equals(s7));

    }


    public static void change(Person p){
        p.name = "小花";
        p.age = 30;
        p.count = 500;
    }
}

class Person{
    String name;
    int age;
    Integer count;


    public Person(String name, int age, Integer count) {
        this.name = name;
        this.age = age;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", count=" + count +
                '}';
    }
}

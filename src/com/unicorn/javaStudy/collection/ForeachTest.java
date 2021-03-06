package com.unicorn.javaStudy.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 *     增强for -- foreach
 * </p>
 * Created on 2021-01-30.
 *
 * @author Unicorn
 */
public class ForeachTest {
    // 遍历集合
    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Person("张三", 23));

        for (Object o : collection) {
            System.out.println(o);
        }
    }

    // 遍历数组
    @Test
    public void test2(){

        int[] arr = new int[]{11,22,33,44};
        for (int i : arr) {
            System.out.println(i);
        }

    }
}

package com.unicorn.javaStudy.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * <p>
 *     集合的遍历操作, 使用 Iterator 迭代器接口
 *     掌握Iterator对象的三个方法
 *     1. hasNext()
 *     2. next()
 *     3. remove()
 * </p>
 * Created on 2021-01-30.
 *
 * @author Unicorn
 */
public class IteratorTest {
    @Test
    public void test1()
    {
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Person("张三", 23));

        Iterator iterator = collection.iterator();

//        System.out.println(iterator.next());    // AA
//        System.out.println(iterator.next());    // BB
//        System.out.println(iterator.next());    // 123
//        System.out.println(iterator.next());    // Person{name='张三', age=23}
//        System.out.println(iterator.next());    // NoSuchElementException

        // 集合遍历通常搭配 hasNext() 和 next()
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2()
    {
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Person("张三", 23));

        // remove()
        Iterator iterator = collection.iterator();
        while (iterator.hasNext())
        {
            Object obj = iterator.next();
            if ("AA".equals(obj)){
                iterator.remove();
            }
        }
        iterator = collection.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}

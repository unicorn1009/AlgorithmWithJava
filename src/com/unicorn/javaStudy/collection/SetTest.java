package com.unicorn.javaStudy.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * <p>
 *     Set接口实现类
 *     无序性 : 不等同随机性, 它有自己的排序逻辑(根据hash值)
 *     不可重复 : 比较时,先比较hash值, 如果hash值不一样, 则直接存入, 如果hash值一样, 则调用equals()方法比较, 因此只有hashcode和equals()均一样才视为同一元素
 *     因此要求: 向Set中添加的对象, 一定要重写hashCode()和 equals()方法, 并且两个方法需要保持一致性(即相同对象必须具有相等的散列码)
 *     |---- HashSet : 作为Set接口的主要实现类, 线程不安全, 可以存储null值, 内部存储结构为数组+链表
 *          |---- LinkedHashSet : 是HashSet的子类, 特点是可以按照添加元素的顺序遍历
 *     |---- TreeSet : 可以按照添加对象的指定属性进行排序, TreeSet只能存储相同类的对象, 内部比较使用compareTo()或compare(), 不使用equals()
 *
 *     Set接口中的方法都是Collection接口中的方法, 没有新增
 * </p>
 * Created on 2021-01-31.
 *
 * @author Unicorn
 */
public class SetTest {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add("AA");
        set.add(new Person("张三", 11));
        set.add(456);
        set.add("BB");
        set.add(456);


        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Object o = iterator.next();
            System.out.println(o + " : "+ o.hashCode());
            System.out.println();
        }
    }

    @Test
    public void test2(){
        // LinkedHashSet : 遍历顺序与添加顺序一致
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add(new Person("张三", 11));
        set.add("CC");
        set.add(456);


        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Object o = iterator.next();
            System.out.println(o + " : "+ o.hashCode());
        }
    }

    @Test
    public void test3(){
        HashSet<List<Integer>> lists = new HashSet<>();
        lists.add(new ArrayList<>(Arrays.asList(1,1,3)));
        lists.add(new ArrayList<>(Arrays.asList(4,5,6)));
        lists.add(new ArrayList<>(Arrays.asList(3,1,1)));

        System.out.println(lists);
    }

}

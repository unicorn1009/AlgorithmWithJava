package com.unicorn.javaStudy.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     List接口的三个实现类
 *     |--- ArrayList : 作为List的主要实现类, 线程不安全, 效率高, 底层使用object[]存储
 *     |--- LinkedList : 底层使用双向链表实现, 对于需要频繁插入和删除操作, 效率比ArrayList更高
 *     |--- Vector : List的古老实现类, 线程安全, 效率低, 底层使用object[]存储
 *
 *     比较ArrayList  LinkedList  Vector 三者异同?
 *     同: 三者均实现List接口, 存储数据的特点相同, 即有序可重复性
 *     异: 同上
 * </p>
 * Created on 2021-01-30.

 * @author Unicorn
 */
public class ListTest {

    @Test
    public void ArrayListTest(){
        // 为了避免频繁扩容带来的额外操作(第一次调用add()方法是尝试设置容量为10, 每次扩容为原来的1.5倍), 建议使用含参构造器
        ArrayList list = new ArrayList(20);
        list.add("AA");
        list.add("BB");
        list.add(123);
        list.add(new Person("张三", 23));
        list.add(456);
        System.out.println(list);

        // add(index, element) : 插入到指定位置
        list.add(1, 789);
        System.out.println(list);

        // get(index) : 按索引获取元素
        System.out.println(list.get(1));

        // set()
        list.set(1,"CC");

        // indexOf(object) : 返回元素首次出现的位置索引, 不存在返回-1
        System.out.println(list.indexOf("BB"));

        // lastIndexOf(object)
        System.out.println(list.lastIndexOf("BB"));

        // remove(object) : 如果有多个只删找到的第一个
        list.add("AA");
        list.remove("AA");
        System.out.println(list);

        // remove(index) : 按索引删除
        list.remove(1);
        System.out.println(list);

        // 取自列表
        List subList = list.subList(1, 3);
        System.out.println(subList);
    }

    public static void main(String[] args) {

    }
}

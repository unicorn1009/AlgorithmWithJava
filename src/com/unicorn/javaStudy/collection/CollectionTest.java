package com.unicorn.javaStudy.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * <p>
 *     集合框架
 *      |---- Collection接口 : 单列数据
 *          |---- List接口 : 有序可重复性
 *              |---- ArrayList  LinkedList  Vector
 *
 *          |---- Set接口 : 无序不可重复
 *              |---- HashSet  LinkedHashSet  TreeSet
 *
 *      |---- Map接口 : 双列数据
 *          |---- HashMap  LinkedHashMap  TreeMap  HashTable  Properties
 *
 * </p>
 * Created on 2021-01-30.
 *
 * @author Unicorn
 */

/*
    Collection接口中定义的方法
 */
public class CollectionTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1(){

        // add()
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Date());
        // size()
        System.out.println(collection.size());  // 4
        // addAll()
        Collection c1 = new ArrayList();
        c1.add("CC");
        c1.add(456);
        collection.addAll(c1);
        System.out.println(collection.size());  // 6
        System.out.println(collection);         // [AA, BB, 123, Sat Jan 30 10:15:48 CST 2021, CC, 456]
        // isEmpty()
        System.out.println(c1.isEmpty());   // false
        // clear() : 清空数据
        c1.clear();
        System.out.println(c1.isEmpty());   // true

        // contains() : 内部会调用equals()方法进行比较
        System.out.println(new String("AA") == "AA");   // false
        System.out.println(collection.contains(new String("AA")));  // true

        // containsAll()
        Collection c2 = Arrays.asList(123, 456);
        System.out.println(collection.containsAll(c2));     // true

        // remove() : 内部会调用equals()方法进行比较 , 返回值: 是否删除成功
        boolean b1 = collection.remove(1234);     // 返回boolean型
        System.out.println(b1);              // false
        System.out.println(collection);     // [AA, BB, 123, Sat Jan 30 10:40:32 CST 2021, CC, 456]
        boolean b2 = collection.remove(456);     // 返回boolean型
        System.out.println(b2);              // true
        System.out.println(collection);     // [AA, BB, 123, Sat Jan 30 10:40:32 CST 2021, CC]

        // removeAll() : 常用于计算差集,  内部会调用equals()方法进行比较 , 返回值 : 两个集合必须有共同元素并且删除成功才返回true
        Collection c3 = Arrays.asList(123, 789);
        boolean b3 = collection.removeAll(c3);
        System.out.println(b3);              // true
        System.out.println(collection);     // [AA, BB, Sat Jan 30 10:39:26 CST 2021, CC]

    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.addAll(Arrays.asList(456,789));
        collection.add(new Person("张三", 23));
        System.out.println(collection);     // [AA, BB, 123, 456, 789, Person{name='张三', age=23}]

        // retainAll : 求交集
        Collection c1 = Arrays.asList(234, 456, 789);
        Collection c2 = collection;
        collection.retainAll(c1);
        System.out.println(collection); // [456, 789]
        System.out.println(c1);         // [234, 456, 789]
        System.out.println(c2);         // [456, 789]
    }

    @Test
    public void test3() {
        // equals() 要求元素和顺序都相同才true
        Collection c1 = new ArrayList();
        c1.add("AA");
        c1.add("BB");
        c1.add(123);

        Collection c2 = new ArrayList();
        c2.add(123);
        c2.add("AA");
        c2.add("BB");
        System.out.println(c1.equals(c2));  // false
    }

    @Test
    public void test4() {
        Collection c1 = new ArrayList();
        c1.add("AA");
        c1.add("BB");
        c1.add(123);
        c1.add(new Person("张三", 23));

        // hashCode() : 返回对象的哈希值, 所有对象均有此方法
        System.out.println(c1.hashCode());      // 88944789

        // toArray() : 集合 --> 数组
        Object[] objects = c1.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }

        // 拓展 : 数组 --> 集合 : 使用Arrays工具类
        List<String> stringList = Arrays.asList(new String[]{"AA", "BB", "DD"});
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}



class Person{
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

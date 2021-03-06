package com.unicorn.javaStudy.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * <p>
 *     |---- Map接口 : 双列数据
 *          |---- HashMap : 作为Map接口的主要实现类, 线程不安全, 效率高 (可以存储null的key和value)
 *              |---- LinkedHashMap
 *          |---- TreeMap : 会对添加的键值对进行排序, 使用key排序
 *          |---- HashTable : 作为Map接口的古老实现类, 线程安全, 效率低 (不可以存储null的key和value)
 *              |---- Properties : 常用于处理配置文件, key和value都是String
 * </p>
 * Created on 2021-01-31.
 *
 * @author Unicorn
 */
public class MapTest {
    @Test
    public void test1(){
        Map<Integer, String> map = new HashMap<>();
        // put(k, v) : 内部会把k,v包装成一个entry对象, 再装入Map
        map.put(11, "第一个");
        map.put(33, "第二个");
        map.put(11, "第三个");
        System.out.println(map);

        // putAll(map)
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(22, "AA");
        map1.put(11, "BB");
        map.put(33, "BB");
        map.putAll(map1);
        System.out.println(map);

        // remove(key) : 返回值为value , key不存在时返回null
        String removeResult = map.remove(22);
        System.out.println(map);
        System.out.println(removeResult);

        // get(key) : 获取指定key的value, key不存在时返回null
        System.out.println(map.get(11));    // BB
        System.out.println(map.get(111));   // null

        // containsKey(key) : 判断key是否存在
        System.out.println(map.containsKey(123));   // false

        // containsValue(key) : 判断value是否存在
        System.out.println(map.containsValue("BB"));

        // isEmpty() : 判空
        System.out.println(map.isEmpty());
    }

    @Test
    public void test2(){
        // Map遍历
        Map map = new HashMap();
        map.put(11, "AA");
        map.put("BB", 12);
        map.put("AA", "CC");

        // 1. 遍历所有key集合 : keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Object key = iterator.next();
            System.out.println(key+" : "+ map.get(key));
        }
        System.out.println("****************");


        // 2. 遍历所有value集合 : values()
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println("****************");

        // 3. 遍历所有Entry : entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator1.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"="+value);

        }

    }

}

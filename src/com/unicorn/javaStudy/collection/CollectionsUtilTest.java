package com.unicorn.javaStudy.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     Collections 工具类 : 用于操作 Collection(List Set) 和 Map
 *
 *     |--- reverse(List) : 反转List的顺序
 *     |--- shuffle(List) : 对List集合随机打乱
 *     |--- sort(List [,Comparator]) : 对List集合进行排序, 默认自然排序, 也可指定定制排序
 *     |--- swap(List, int i, int j) : 交换指定索引位置的元素
 *
 *     |--- max(Collection [,Comparator]) : 返回集合中的最大值
 *     |--- min(Collection [,Comparator]) : 返回集合中的最小值
 *     |--- frequency(Collection, Object) : 返回指定元素出现的次数
 *     |--- copy(List dest, List src) : 将集合src复制给集合dest (须注意写法, 使用Arrays.asList()撑起集合的size)
 *
 *     |--- synchronizedXxx() : 返回线程安全的集合版本
 *
 *
 * </p>
 * Created on 2021-01-31.
 *
 * @author Unicorn
 */
public class CollectionsUtilTest {
    @Test
    public void test(){

        List list = new ArrayList();
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(11);
        System.out.println(list.size());
        List list1 = new ArrayList(list.size());
        System.out.println(list1.size());

    }
}

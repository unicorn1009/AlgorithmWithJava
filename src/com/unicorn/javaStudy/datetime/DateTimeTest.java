package com.unicorn.javaStudy.datetime;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     1.8之前使用的日期类
 * </p>
 * Created on 2021-01-28.
 *
 * @author Unicorn
 */
public class DateTimeTest {

    // 1. System.currentTimeMillis() : 时间戳  (1.8之前)
    @Test
    public void test1()
    {
        System.out.println(System.currentTimeMillis()); // 单位毫秒
    }

//     2. java.util.Date类       (1.8之前)
    @Test
    public void test2()
    {
        // 两个构造器的使用
        // 两个方法的使用
        // 构造器一
        Date date1 = new Date();
        // 构造器二
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println(date1); // toString()方法 : 格式: Thu Jan 28 22:18:50 CST 2021
        System.out.println(date2);
        System.out.println(date1.getTime());    // getTime():  获取当前时间的时间戳

    }

    // 3. java.text.SimpleDateFormat类   (1.8之前)
    @Test
    public void test3(){
        /*
            SimpleDateFormat主要用于对日期Date类的格式化和解析
            掌握两个操作
            1. 格式化: 日期   --> 字符串
            2. 解析:   字符串 --> 日期
         */

        // 实例化一 : 默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();
        System.out.println(date);       // Thu Jan 28 22:47:23 CST 2021

        // 1. 格式化: 日期   --> 字符串
        String format = sdf.format(date);
        System.out.println(format);     // 21-1-28 下午10:47

        // 2. 解析: 字符串 --> 日期 (格式有要求)
//        String str = "2021/1/28 下午10:30:30";    // 解析失败
        String str = "2021-1-28 下午10:30:30";    // 解析成功
        Date parseDate = null;
        try {
            parseDate = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parseDate);

        System.out.println("*******************************");
        // 实例化二 : 含参构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);
        str = "2021/1/28 22:30:30";
        Date parseDate1 = null;
        try {
            parseDate1 = sdf1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parseDate1);
    }

}

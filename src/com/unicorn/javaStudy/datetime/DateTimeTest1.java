package com.unicorn.javaStudy.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * <p>
 *     1.8之后使用的日期类 : LocalDate / LocalTime / LocalDateTime(最常用)
 * </p>
 * Created on 2021-01-28.
 *
 * @author Unicorn
 */
public class DateTimeTest1 {

    @Test
    public void test1()
    {
        // 实例化1: 调now()静态方法 : 获取当前日期时间
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println("***************************");


        // 实例化2: 调of()静态方法 : 指定日期时间
        LocalDateTime localDateTime = LocalDateTime.of(2021, 05, 21, 20, 0, 0);
        System.out.println(localDateTime);
        System.out.println("***************************");


        // 常用操作
        // 获取 getXxx()
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println("***************************");

        // 设置 withXxx() (LocalDateTime不可变)
        LocalDateTime withDayOfMonth = localDateTime.withMonth(1).withDayOfMonth(1);
        System.out.println(withDayOfMonth);
        System.out.println("***************************");

        // 加减 plusXxx()
        LocalDateTime plusDays = localDateTime.plusDays(20);
        System.out.println(plusDays);

    }

    @Test
    public void test2()
    {
        // DateTimeFormatter : 格式化和解析日期时间, 类似于SimpleDateFormat
        // 实例化方式一: 预定义 (不常用)
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化 : 日期 -> 字符串
        String s = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(s);
        // 解析 : 字符串 -> 日期
        TemporalAccessor parse = dateTimeFormatter1.parse("2021-01-29T10:58:56");
        System.out.println(parse);

        // 实例化方式二: 本地化
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String s1 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(s1);

        // 实例化方式三 : 自定义 (最常用)
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String s2 = dateTimeFormatter3.format(LocalDateTime.now());
        System.out.println(s2);


    }
}

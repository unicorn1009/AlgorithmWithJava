package com.unicorn.javaStudy.compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>
 * </p>
 * Created on 2021-01-29.
 *
 * @author Unicorn
 */
public class CompareTest {

    @Test
    public void test1(){
        // String 实现了Comparable接口,并重写了compareTo()方法
        String[] arr = new String[]{"GG", "BB", "DD", "AA", "CC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("**************************");

        // 自定义排序 之 自然排序: 实现Comparable接口
        Student[] students = new Student[5];
        students[0] = new Student("xiaoming", 16, 77.5);
        students[1] = new Student("lilei", 15, 50.0);
        students[2] = new Student("wangwu", 17, 89.5);
        students[3] = new Student("caohui", 14, 89.5);
        students[4] = new Student("zhangsan", 16, 72.5);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

    }

    @Test
    public void test2(){
        // 自定义排序 之 定制排序: 实现Comparator接口, 重写compare方法
        // 需求: 对字符串数组中的字符串默认排序规则逆序排序
        String[] arr = new String[]{"GG", "BB", "DD", "AA", "CC"};
        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return -s1.compareTo(s2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}

class Student implements Comparable<Student>{

    private String name;
    private Integer age;
    private Double score;

    public Student() {
    }

    public Student(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        // 先按成绩排序, 再按姓名排序
        // 法一:
        if (this.score > student.score){
            return 1;
        }else if (this.score < student.score){
            return -1;
        }else {
            // 成绩相当, 按姓名排序
            return this.name.compareTo(student.name);
        }
        // 法二:
        // return Double.compare(this.score, student.score);

    }
}

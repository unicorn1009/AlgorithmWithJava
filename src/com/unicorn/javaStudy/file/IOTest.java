package com.unicorn.javaStudy.file;

/**
 * <p>
 *     IO流
 *     分类:
 *      按数据单位 : 字节流(8bit) 字符流
 *      按数据流向 : 输入流  输出流
 *
 *      IO流涉及40多个类, 但都是从4个抽象基类派生而来:
 *      输入流 : InputStream(字节流)   Reader(字符流)
 *      输出流 : OutputStream(字节流)   Writer(字符流)
 *
 *      重点关注的子类:
 *      访问文件 : FileInputStream FileOutputStream FilReader FileWriter
 *      缓冲流 : BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter
 *      转换流 : InputStreamReader OutputStreamWriter
 *      对象流 : ObjectInputStream ObjectOutputStream
 *
 * </p>
 * Created on 2021-02-02.
 *
 * @author Unicorn
 */
public class IOTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 12);
        Student s2 = s1;
        s2.name = "李四";
        s2.age = 20;
        System.out.println(s1);
        System.out.println(s2);
    }
}

class Student{
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public  Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}

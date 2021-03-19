package com.unicorn.niuke;

import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/03/18 19:24
 *
 * @author Unicorn
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

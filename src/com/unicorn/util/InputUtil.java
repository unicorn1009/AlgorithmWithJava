package com.unicorn.util;

import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021-7-7.
 *
 * @author Unicorn
 */
public class InputUtil {

    public static void main(String[] args) {


    }

    // 读取连续整数
    public void input1(){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
        }
    }

    // 读取有限整数
    public void input2(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        while(n-->0){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
        }
    }

    // 每行读取空格隔开的整数
    public void input3(){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String[] temp=in.nextLine().split(" ");
            int sum=0;
            for(String s:temp)
                sum+=Integer.parseInt(s);
            System.out.println(sum);
        }
    }
}

package com.unicorn.笔试.牛客0729;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <p>
 *     2,3,4个数a,b,c
 *     多少个5使均值大于4
 * </p>
 * Created on 2021-7-29.
 *
 * @author Unicorn
 */
public class T02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            solution(a, b, c);
        }
    }

    public static void solution(long a, long b, long c){
        long x = 2*a+3*b+4*c;
        long abc = a+b+c;
        int d = 0;
        while (true){
            if ((x + 5*d) * 1.0 / (abc+d) >= 3.5){
                break;
            }else {
                d++;
            }
        }
        System.out.println(d);
    }
}

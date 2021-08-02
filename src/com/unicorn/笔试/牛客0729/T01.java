package com.unicorn.笔试.牛客0729;

import java.util.Scanner;

/**
 * <p>
 *     不可重复集合的和
 * </p>
 * Created on 2021-7-29.
 *
 * @author Unicorn
 */
public class T01 {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(i + " === " + getSize(i));
        }
    }


    public static int getSize (long k) {
        if (k == 1) return 1;
        return (int)Math.ceil(Math.log(k)/Math.log(2));

//        // write code here
//        for (long n = 0; n <= k; n++) {
//            if (n*(n+1) >= 2*k){
//                return (int) n;
//            }
//        }
//        return -1;
    }
}

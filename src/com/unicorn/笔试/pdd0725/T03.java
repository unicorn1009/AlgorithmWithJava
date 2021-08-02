package com.unicorn.笔试.pdd0725;

import java.util.*;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-25 7:46 下午
 */
public class T03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int nums = sc.nextInt();
            for (int i = 0; i < nums; i++) {
                Long a = sc.nextLong();
                Long b = sc.nextLong();
                Long c = sc.nextLong();
                Long q = sc.nextLong();

                if (method(a,b,c,q))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        }
    }

    public static boolean method(Long a, Long b, Long c, Long q){
        if (a.equals(q)) return true;
        Long t1 = a;
        Long t2 = a;
        while (true){
            t1 = t1+b;
            t2 = t2 * c;
            if (t1.equals(q) || t2.equals(q)) return true;
            if (t1 > q && t2 > q) return false;
        }
    }
}

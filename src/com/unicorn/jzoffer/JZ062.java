package com.unicorn.jzoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>
 *     剑指 Offer 62. 圆圈中最后剩下的数字
 * </p>
 * Created on 2021/3/15 0015
 *
 * @author Unicorn
 */
public class JZ062 {
    public static void main(String[] args) {
        System.out.println(lastRemaining2(100 ,238));
    }

    public static int lastRemaining2(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }


    // 超时
    public static int lastRemaining1(int n, int m) {
        boolean[] isRemoved = new boolean[n];
        int left = n, k = 0, i = 0;
        while (left > 1){
            if (i >= n)
                i = 0;
            if (isRemoved[i]){
                i++;
                continue;
            }
            k++;
            if (k % m == 0){
                isRemoved[i] = true;
                k = 0;
                left--;
                System.out.println("移除 : " + i);
            }
            ++i;
        }
        System.out.println("i == "+ i);
        for (int j = i; j < n; j++) {
            if (!isRemoved[j])
                return j;
        }
        for (int j = 0; j < i; j++) {
            if (!isRemoved[j])
                return j;
        }
        return 1;
    }

    // 超时
    public static int lastRemaining(int n, int m) {
        // 一个队列
        Deque<Integer> queue = new LinkedList<>();
        int k = 0;
        for (int i = 0; i < n; i++) {
            k++;
            if (k == m){
                k = 0;
//                System.out.println("移除 : " + i);
                continue;
            }
            queue.addLast(i);
//            System.out.println("添加:" + i);
        }
        if (queue.size() == 0) return n-1;
        while (queue.size() > 1){
            k++;
            if (k == m){
                Integer first = queue.removeFirst();
                k = 0;
//                System.out.println("-移除 : " + first);
            }else {
                Integer first = queue.removeFirst();
                queue.addLast(first);
            }
        }
        return queue.peekFirst();
    }
}

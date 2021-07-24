package com.unicorn.笔试.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/07/21 20:31
 *
 * @author Unicorn
 */
public class T022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            PriorityQueue<int[]> Q =new PriorityQueue<int[]>((a,b)->{
                if (a[1] != b[1]) return a[1]- b[1];
                return b[0]-a[0];
            });
            for (int i = 0; i < n; i++) {
                int[] product = new int[2];
                product[0] = sc.nextInt();
                product[1] = sc.nextInt();
                Q.add(product);
            }
            int[] a = new int[m];
            while (!Q.isEmpty()){
                int[] product = Q.poll();
                a[get(a)] += product[0];
            }
            int rs = 0;
            for (int time : a){
                if (time > rs){
                    rs = time;
                }
            }
            System.out.println(rs);

        }
    }

    private static int get(int[] A){
        int idx = 0;
        int time = A[0];
        for (int i = 1; i < A.length; i++) {
            if (time > A[i])
            {
                time = A[i];
                idx = i;
            }
        }
        return idx;
    }
}

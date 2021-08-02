package com.unicorn.笔试.华为0720;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-21 10:37 下午
 */
public class 仪器使用调度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();   // 贵重仪器数量
            int K = sc.nextInt();   // 人数
            PriorityQueue<int[]> Q = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // 先比优先级, 优先级越小越优先, 同优先级时间越大越优先
                    if (o1[1] != o2[1]){
                        return o1[1] - o2[1];
                    }else {
                        return o2[0] - o1[0];
                    }
                }
            });
            for (int i = 0; i < K; i++) {
                int[] arr = new int[2];
                arr[0] = sc.nextInt();  // 时间
                arr[1] = sc.nextInt();  // 优先级
                Q.add(arr);
            }
            int[] equipments = new int[N];
            while (!Q.isEmpty()){
                int index = 0;
                for (int i = 1; i < equipments.length; i++) {
                    if (equipments[i] < equipments[index]){
                        index = i;
                    }
                }
                equipments[index] += Q.remove()[0];
            }
            int ans = 0;
            for (int i = 0; i < equipments.length; i++) {
                ans = Math.max(ans, equipments[i]);
            }
            System.out.println(ans);
        }
    }

    private static void scheduling(){

    }
}

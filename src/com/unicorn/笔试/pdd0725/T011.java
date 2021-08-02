package com.unicorn.笔试.pdd0725;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-25 7:27 下午
 */
public class T011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int lineNums = sc.nextInt();
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0])
                        return o1[0]-o2[0];
                    else
                        return o2[1] - o1[1];
                }
            });
            for (int i = 0; i < lineNums; i++) {
                int[] line = new int[2];
                line[0] = sc.nextInt();
                line[1] = sc.nextInt();
                priorityQueue.add(line);
            }
            boolean flag = false;
            int[] last = priorityQueue.poll();
            while (!priorityQueue.isEmpty()){
                int[] poll = priorityQueue.poll();
                if (last[0] <= poll[0] && last[1] >= poll[1]){
                    flag = true;
                    break;
                }
                last = poll;
            }
            System.out.println(flag);
        }
    }
}

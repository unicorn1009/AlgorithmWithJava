package com.unicorn.niuke.排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 * Created on 2021/04/19 11:01
 *
 * @author Unicorn
 */
public class 最小的K个数 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = GetLeastNumbers_Solution(new int[]{5, 1, 0, 6, 2, 44, 45, 12, 4, 7, 8, 2, 22, 41}, 5);
        System.out.println(integers);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length == 0 || k == 0 || k > input.length) return new ArrayList<>(0);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] <= priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(input[i]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(priorityQueue);
        return ans;
    }
}

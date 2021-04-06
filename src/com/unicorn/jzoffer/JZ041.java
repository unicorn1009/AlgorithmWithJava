package com.unicorn.jzoffer;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <p>
 *     剑指 Offer 41. 数据流中的中位数
 * </p>
 * Created on 2021/04/05 16:53
 *
 * @author Unicorn
 */
public class JZ041 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 1; i < 10; i++) {
            medianFinder.addNum(i);
            System.out.println(i + " : " + medianFinder.findMedian());
        }
    }
}

class MedianFinder {

    private PriorityQueue<Integer> pq;
    private int count;
    private int pre;

    public MedianFinder() {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        count = 0;
    }

    public void addNum(int num) {
        // pq只保存一半的数
        pq.add(num);
        count++;
        if (count % 2 == 0){
            // 总共偶数个数
            pre = pq.remove();
        }
    }

    public double findMedian() {
        if (count % 2 == 0){
            // 有偶数个数
            return (pre + pq.peek()) * 1.0 / 2;
        }else {
            return pq.peek();
        }
    }
}

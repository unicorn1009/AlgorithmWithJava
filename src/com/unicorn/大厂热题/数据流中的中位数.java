package com.unicorn.大厂热题;

import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-26 10:11 下午
 */
public class 数据流中的中位数 {
    public static void main(String[] args) {
        MedianFinder aaa = new MedianFinder();
        for (int i = 1; i <= 10; i++) {
            aaa.addNum(i);
            System.out.println(aaa.findMedian());
        }
    }


    static class MedianFinder {

        /** initialize your data structure here. */
        public MedianFinder() {
            this.N = 0;
        }

        // 右边小顶堆
        private PriorityQueue<Integer> right = new PriorityQueue<>();
        // 左边大顶堆
        private PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> {
            return o2-o1;
        }));

        // 插入数据个数
        private int N;

        // 插入保证左边少于等于右边(最多少1个)
        // 要保证左边全部数据小于右边小顶堆最小的
        public void addNum(int num) {
            // 如果插入前N为偶数, 则需要往右边插
            if (N % 2 == 0){
                // 但是不能直接往右边插, 因为新来的数不一定比左边算有的数字都大
                // 所以先把当前数插到左边, 再取出左边最大的数插到右边
                if (!left.isEmpty() && num >= left.peek()){
                    right.add(num);
                }else {
                    left.add(num);
                    right.add(left.remove());
                }
            }else {
                // 如果插入前 N是奇数, 则需要往左边插
                // 同样需要先插入右边,再取出右边最大的插入左边
                if (!left.isEmpty() && num <= left.peek()){
                    left.add(num);
                }else {
                    right.add(num);
                    left.add(right.remove());
                }
            }
            N++;
        }

        public double findMedian() {
            if (N % 2 == 0){
                // 偶数个, 左右各取一个
                return (left.peek()+right.peek())/2.0;
            }else
                return (double)right.peek();
        }
    }
}

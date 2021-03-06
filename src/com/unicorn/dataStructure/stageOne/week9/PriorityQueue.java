package com.unicorn.dataStructure.stageOne.week9;

import com.unicorn.dataStructure.stageOne.week3.Queue;

/**
 * <p>
 *     使用最大堆实现优先队列
 * </p>
 * Created on 2021/3/2.
 *
 * @author Unicorn
 */
public class PriorityQueue implements Queue {

    private MaxHeap maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(Object o) {
        maxHeap.add((Integer) o);
    }

    @Override
    public Integer dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public Object getFront() {
        return maxHeap.findMax();
    }
}

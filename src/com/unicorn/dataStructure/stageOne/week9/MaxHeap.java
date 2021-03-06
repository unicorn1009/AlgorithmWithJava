package com.unicorn.dataStructure.stageOne.week9;

import com.unicorn.common.ArrayGenerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *     使用数组实现最大堆
 * </p>
 * Created on 2021/3/2.
 *
 * @author Unicorn
 */
public class MaxHeap {
    public static void main(String[] args) {
        // 测试堆排序
        int n = 10;
        Integer[] integers = ArrayGenerate.generateArrayRandom(n, n);
        System.out.println(Arrays.toString(integers));
        MaxHeap maxHeap = new MaxHeap();
        for (Integer i : integers){
            maxHeap.add(i);
        }
        for (int i = n-1; i>=0; i--){
            integers[i] = maxHeap.extractMax();
        }
        System.out.println(Arrays.toString(integers));
    }

    private ArrayList<Integer> data;

    public MaxHeap(){
        data = new ArrayList<>();
    }

    public MaxHeap(int capacity){
        data = new ArrayList<>(capacity);
    }

    // Heapify 传入一个数组, 将该数组原地排成一个堆
    public MaxHeap(Integer[] arr){
        data = (ArrayList)Arrays.asList(arr);
        for (int i = parent(arr.length-1); i >= 0; i--){
            siftDown(i);
        }
    }

    // 获取堆中元素个数
    public int size(){
        return data.size();
    }

    // 判断堆是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 获取指定索引节点的父亲节点的索引
    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("索引错误");
        return (index -1) / 2;
    }

    // 获取指定索引节点的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 获取指定索引节点的左孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(int e){
        data.add(e);
        siftUp(data.size()-1);
    }

    /**
     * 元素上浮
     * @param k 上浮元素的索引
     */
    private void siftUp(int k) {
        // 如果当前索引位置的元素比父亲节点更大
        while (k > 0 && data.get(k) > data.get(parent(k))){
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void swap(int i, int j) {
        // 判断索引是否越界
        if (i < 0 || i >= data.size() || j < 0 || j >= data.size()){
            throw new IllegalArgumentException("索引错误");
        }

        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    // 获取堆中最大元素
    public int findMax(){
        if (data.isEmpty())
            throw new IllegalArgumentException("堆为空");
        return data.get(0);
    }

    // 取出堆中最大元素 (取出并删除) , 返回最大值
    public int extractMax(){
        int ret = findMax();

        // 删除当前堆的最大元素
        // 1. 用堆最后一个位置的元素替换最大元素, 并删去最后一个元素
        swap(0, size()-1);
        data.remove(size()-1);
        // 2. 元素下沉
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        // 如果存在左孩子
        while (leftChild(k) < size()){
            // 找出当前下沉元素的左右孩子中较大的那个
            int i = leftChild(k);
            // 如果有右孩子, 则比较左右孩子大小, 如果右孩子大, 则i指向右孩子
            if (i+1 < size() && data.get(i) < data.get(i+1))
                i++;

            if (data.get(k) >= data.get(i)){
                break;
            }else {
                swap(k, i);
                k = i;
            }
        }
    }
}

package com.unicorn.jzoffer;

import com.unicorn.common.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * <p>
 *     最小的k个数
 *     输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * </p>
 * Created on 2021/2/24.
 *
 * @author Unicorn
 */
public class JZ040 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,1};
        int[] res = new JZ040().getLeastNumbers2(arr, 1);
        System.out.println(Arrays.toString(res));
    }
    // 方法二 : 使用最大堆(优先队列)(注意:找最小K个元素要用最大堆)
    public int[] getLeastNumbers2(int[] arr, int k) {
        // Java提供的PriorityQueue优先队列默认实现是最小堆, 如果要使用最大堆, 需要传入一个比较器参数
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.remove();
        }
        return ret;
    }

    // 方法一 : 使用快速排序
    public int[] getLeastNumbers1(int[] arr, int k) {
        sort(arr, k, 0, arr.length-1, new Random());
        System.out.println(Arrays.toString(arr));
        return Arrays.copyOfRange(arr,0,k);
    }

    private void sort(int[] arr, int k, int left, int right, Random rdm){
        if (left >= right) return;
        int p = partition(arr, left, right, rdm);
        System.out.println("   p = "+p);
        if (p == k-1){
            return;
        }else if (p < k-1){
            // 去右边找
            sort(arr, k, p+1, right, rdm);
        }else {
            // 去左边找
            sort(arr, k, left, p-1, rdm);
        }
    }

    private int partition(int[] arr, int left, int right, Random rdm) {

        swap(arr, rdm.nextInt(right-left+1)+left, left);
        int i = left+1, j = right;
        while (true){
            while (i<=j && arr[i] < arr[left])
                i++;
            while (i<=j && arr[j] > arr[left])
                j--;
            if (i>=j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, left);
        System.out.print("after partition : "+Arrays.toString(arr));
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

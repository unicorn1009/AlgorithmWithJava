package com.unicorn.Leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * <p>
 *     215. 数组中的第K个最大元素
 * </p>
 * Created on 2021/3/2.
 *
 * @author Unicorn
 */
public class Solution0215 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        Solution0215 solution0215 = new Solution0215();
        System.out.println(solution0215.findKthLargest(nums, 3));
        System.out.println(solution0215.findKthLargest1(nums, 3));
    }

    // 方法一 : 使用优先队列(默认底层实现为最小堆)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (!pq.isEmpty() && nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    // 使用快排
    private int k;
    private int ans;
    public int findKthLargest1(int[] nums, int k) {
        this.k = k;
        sort(nums, 0, nums.length-1);
        return ans;
    }

    public void sort(int[] arr, int left, int right){
        if (left >= right) return;
        int p = partition(arr, left, right);
        // 第k大的对应第arr.length - k小的(从0开始算)
        if (p == arr.length - k){
            ans = arr[p];
            return;
        }
        // 左边排序
        sort(arr, left, p-1);
        // 右边排序
        sort(arr, p+1, right);
    }

    // 对数组进行分区, 以枢纽为界, 左侧全部小于枢纽, 右侧全部大于枢纽, 返回枢纽最终所在位置
    private int partition(int[] arr, int left, int right) {
        // 优化点 : 随机选取枢轴元素. 将选中的枢轴元素交换到最左边
        int p = left + (new Random()).nextInt(right-left+1);
        swap(arr, left, p);

        int i = left+1, j = right;
        while (true){
            // 从左往右找到第一个比枢纽元素大的, 注意循环条件
            while (i <= j && arr[i] < arr[left])
                i++;
            // 从右往左找到第一个比枢纽元素小的,注意循环条件
            while (i <= j && arr[j] > arr[left])
                j--;
            // 循环终止条件
            if (i >= j) break;
            // 交换两个位置的元素
            swap(arr, i, j);
            // i往后走一步, j往前走一步, 继续循环
            i++;
            j--;
        }
        // 最后交换枢纽元素和j停留的位置
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

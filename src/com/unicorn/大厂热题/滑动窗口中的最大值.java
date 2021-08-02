package com.unicorn.大厂热题;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 * Created on 2021-7-30.
 *
 * @author Unicorn
 */
public class 滑动窗口中的最大值 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size > num.length || size < 1)
            return ans;
        // 大顶堆, 堆顶是最大值
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ans.add(heap.peek());
        /* 维护一个大小为 size 的大顶堆 */
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            // 滑出窗口的数出堆, 新加入窗口的数入堆
            heap.remove(num[i]);
            heap.add(num[j]);
            // 取新窗口中的最大值
            ans.add(heap.peek());
        }
        return ans;
    }
}

package com.unicorn.大厂热题;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 *     输入n k，n表示有1.2.....n，n个数，输出他们所有排列里第k大的数，k超过排列个数输出-1
 *     例输入3 2 输出132
 *     输入4 1 输出1234
 *     输入4 30 输出-1
 * </p>
 * Created on 2021-7-29.
 *
 * @author Unicorn
 */
public class 所有排列里第k大的数 {
    public static void main(String[] args) {
        所有排列里第k大的数 aaa = new 所有排列里第k大的数();
        System.out.println("答案是："+aaa.solution(5,5));
    }
    private Deque<String> queue;

    private boolean isStop;

    public int solution(int n, int k){
        queue = new ArrayDeque<>();
        int count = n;
        int x = n;
        while (x > 1){
            count = count*(x-1);
            x--;
        }
        if (k > count) return -1;
        String[] nums = new String[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = String.valueOf(i);
        }

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            vis[i] = true;
            dfs(nums, vis, n,1, nums[i], k);
            vis[i] = false;
        }

        // 深搜完毕后，依次出队k个即为第k大的数
        String ans = "";
        for (int i = 0; i < k; i++) {
            ans = queue.removeFirst();
        }
        return Integer.parseInt(ans);
    }

    private void dfs(String[] nums, boolean[] vis,int n, int count, String curNum, int k) {
        if (count == n){
            // 深搜结束
            System.out.println(curNum);
            queue.addLast(curNum);
            // 已经取得第k大元素，可停止搜索
            if (queue.size() == k){
                isStop = true;
            }
            return;
        }
        // 可停止搜索则直接返回
        if (isStop){
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]){
                vis[i] = true;
                dfs(nums, vis, n, count+1, curNum+nums[i], k);
                vis[i] = false;
            }
        }
    }
}

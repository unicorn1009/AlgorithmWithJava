package com.unicorn.大厂热题;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 * Created on 2021-8-3.
 *
 * @author Unicorn
 */
public class 字典序的第K小数字 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(findKthNumber(4289384,1922239));
        long end1 = System.nanoTime();
        System.out.println(findKthNumber1(4289384,1922239));
        long end2 = System.nanoTime();
        System.out.println((end1-start)/1e6 + " ms");
        System.out.println((end2-end1)/1e6 + " ms");

    }

    public static int findKthNumber(int n, int k) {
        // 当前前缀
        long cur = 1;
        // 第k小的index = k-1 (下标从0开始)
        k--;

        while(k > 0){
            int nodes = getNodes(n, cur);
            // 如果当前前缀下包含的节点数量少于k， 则目标值不在当前前缀下
            if(k >= nodes){
                // k减去当前前缀下所有节点数量
                k -= nodes;
                // 去下一个前缀下寻找（往右走一个）
                cur++;      //go right
            }else{
                // 如果当前前缀下节点数量已经够输出k来，则目标值就在当前前缀树里
                // cur * 10 、 k-1表示往下走一层
                k--;
                cur *= 10;  //go down
            }
        }

        return (int)cur;
    }

    // 获取当前前缀下包含多少个数字
    private static int getNodes(int n, long cur){

        // next表示下一个前缀是多少
        long next = cur + 1;
        long totalNodes = 0;

        while(cur <= n){
            // 累加一层的节点个数
            totalNodes += Math.min(n - cur + 1, next - cur);
            // 去到更下一层
            next *= 10;
            cur *= 10;
        }
        return (int)totalNodes;
    }


    // 排序超时
    public static int findKthNumber1(int n, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2)->{
            return o1.toString().compareTo(o2.toString());
        });
        for (int i = 1; i <= n; i++) {
            priorityQueue.add(i);
        }
        while (k-->1){
            priorityQueue.remove();
        }
        return priorityQueue.remove();
    }
}

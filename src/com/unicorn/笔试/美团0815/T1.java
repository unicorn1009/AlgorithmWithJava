package com.unicorn.笔试.美团0815;

import java.util.Scanner;

/**
 * <p>
 *     小美的序列检查
 *     给定n个数, 问这n个数能否组成1到n的不间断序列,能则输出Yes, 不能输出No
 *     输入说明:
 *     第一行T,表示T组数据
 *     对于每组数据,第一行输入n,表示序列有n个数字, 接下来一行有空格分开的n个数字
 *     如
 *     2 1 3 输出Yes
 *     4 4 1 3 输出No
 *     每组数据长度<1000
 * </p>
 *
 * @author unicorn
 * @create 2021-08-15 7:13 下午
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int T = sc.nextInt();
            while (T-->0){
                int n = sc.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = sc.nextInt();
                }
                System.out.println(solution(nums));
            }
        }
    }

    public static boolean solution(int[] nums){
        int n = nums.length;
        int[] counts = new int[n+1];
        for (int num : nums) {
            if (num <= n) {
                counts[num]++;
                if (counts[num] > 1) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}

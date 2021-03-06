package com.unicorn.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>
 *     剑指 Offer 57 - II. 和为 s 的连续正数序列
 *     输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *      序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * </p>
 * Created on 2021/3/3.
 *
 * @author Unicorn
 */
public class JZ057_2 {
    public static void main(String[] args) {
        int[][] sequence = new JZ057_2().findContinuousSequence2(15);
        System.out.println(Arrays.toString(sequence));
    }
    // 滑动窗口(双指针)
    public int[][] findContinuousSequence2(int target) {

        ArrayList<int[]> list = new ArrayList<>();

        int left = 1, right = 2;
        int sum;
        while (left < right && left <= target/2){
            sum = (left+right)*(right-left+1)/2;
            if (sum < target)
                right++;
            else if (sum > target)
                left++;
            else {
                int[] ans = new int[right - left + 1];
                for (int i = 0; i < right - left + 1; i++) {
                    ans[i] = left+i;
                }
                list.add(ans);
                System.out.println(Arrays.toString(ans));
                left++;
            }

        }
        // ArrayList 转二维数组(学习此转换方法)
        return list.toArray(new int[list.size()][]);
    }

    // 复杂度偏高
    public int[][] findContinuousSequence1(int target) {
        // a1 为首项
        ArrayList<int[]> ret = new ArrayList<>();
        // 要求至少包含两个值,
        for (int a1 = 1; a1 <= target/2; a1++) {
            // n 为项数
            int n = 2;
            while (true){
                int sum = n*a1+n*(n-1)/2;
                if (sum > target) break;
                if (sum == target){
                    // 得到一个正确解
                    int[] ans = new int[n];
                    for (int i = 0; i < n; i++) {
                        ans[i] = a1+i;
                    }
//                    System.out.println(Arrays.toString(ans));
                    ret.add(ans);
                    n++;
                }else   // 和小于target
                    n++;
            }
        }

        // ArrayList 转二维数组
        int[][] answer = new int[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            answer[i] = ret.get(i);
        }
        return answer;
    }
}

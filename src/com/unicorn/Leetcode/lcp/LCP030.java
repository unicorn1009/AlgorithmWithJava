package com.unicorn.Leetcode.lcp;

import java.util.*;

/**
 * <p>
 *     LCP 30. 魔塔游戏
 * </p>
 * Created on 2021/04/05 20:13
 *
 * @author Unicorn
 */
public class LCP030 {
    public static void main(String[] args) {
        int[] arr = new int[]{100,100,100,-250,-60,-140,-50,-50,100,150};
        System.out.println(magicTower(arr));
    }
    public static int magicTower(int[] nums) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        long sum = 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                queue.add(-nums[i]);
            }
            sum += nums[i];
            if (sum <= 0){
                Integer remove = queue.remove();
                sum += remove;
                list.add(remove);
                ans++;
            }
        }

        for (Integer integer : list) {
            sum -= integer;
        }

        if (sum < 0){
            return -1;
        }else {
            return ans;
        }
    }
}

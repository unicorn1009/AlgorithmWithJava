package com.unicorn.Leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 *     470. 用 Rand7() 实现 Rand10()
 * </p>
 * Created on 2021-8-10.
 *
 * @author Unicorn
 */
public class Solution0470 {
    public static void main(String[] args) {
        Solution0470 solution0470 = new Solution0470();
        int[] nums = new int[11];
        for (int i = 0; i < 100; i++) {
            nums[solution0470.rand10()]++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public int rand7(){
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    public int rand10(){
        while (true){
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40)
                return num % 10 + 1;
            rand10();
        }
    }

    public int rand10x() {
        int sum = 0;
        for(int i = 0; i < 10 ; i++){
            sum += rand7();
        }
        return sum % 10 + 1;
    }
}

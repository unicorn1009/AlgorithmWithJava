package com.unicorn.niuke.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     给出一个整数数组，请在数组中找出两个加起来等于目标值的数，(假设给出的数组中只存在唯一解)
 *     你给出的函数twoSum 需要返回这两个数字的下标（index1，index2）
 *     注意：下标是从1开始的
 * </p>
 * Created on 2021/04/27 10:24
 *
 * @author Unicorn
 */
public class 两数之和 {
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();   // (target - numbers[index], index)
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])){
                ans[0] = map.get(numbers[i]);
                ans[1] = i+1;
            }else {
                map.put(target-numbers[i], i+1);
            }
        }
        return ans;
    }
}

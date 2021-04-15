package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/04/08 19:59
 *
 * @author Unicorn
 */
public class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int candy : candies) {
            ans.add((candy + extraCandies) >= max);
        }
        return ans;
    }
}

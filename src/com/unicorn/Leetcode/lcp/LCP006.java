package com.unicorn.Leetcode.lcp;

/**
 * <p>
 * </p>
 * Created on 2021/04/08 20:16
 *
 * @author Unicorn
 */
public class LCP006 {
    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count += (coin % 2) == 1 ? (coin / 2)+1 : coin/2;
        }
        return count;
    }
}

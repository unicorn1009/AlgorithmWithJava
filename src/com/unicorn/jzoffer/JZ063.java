package com.unicorn.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     剑指 Offer 63. 股票的最大利润
 * </p>
 * Created on 2021/03/26 21:27
 *
 * @author Unicorn
 */
public class JZ063 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("麻子");
        List<String> subList = list.subList(2, 4);
        System.out.println(list);
        System.out.println(subList);
        list.set(2,"小黄");
        System.out.println(list);
        System.out.println(subList);
        list.add(2,"小红");
        System.out.println(list);
        System.out.println(subList);


    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;

    }
}

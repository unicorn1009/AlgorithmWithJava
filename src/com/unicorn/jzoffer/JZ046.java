package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 46. 把数字翻译成字符串
 * </p>
 * Created on 2021/03/31 08:58
 *
 * @author Unicorn
 */
public class JZ046 {
    public static void main(String[] args) {
        System.out.println(translateNum(5006));
    }
    public static int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        if (len == 1) return 1;
        int[] dp = new int[len];
        dp[0] = 1;
        if (Integer.parseInt(numStr.substring(0,2)) <= 25)
            dp[1] = 2;
        else
            dp[1] = 1;
        for (int i = 2; i < len; i++) {
            int curNums = Integer.parseInt(numStr.substring(i - 1, i + 1));
            if (curNums <= 25 && curNums != Integer.parseInt(numStr.substring(i,i+1))){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[len-1];
    }
}

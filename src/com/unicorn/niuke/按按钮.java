package com.unicorn.niuke;

/**
 * <p>
 * </p>
 * Created on 2021/03/18 19:26
 *
 * @author Unicorn
 */
public class 按按钮 {
    public static void main(String[] args) {
        System.out.println(findMaxButtons(new int[]{1,1,4,5,1,4}));
        System.out.println(findMaxButtons(new int[]{2,3,4}));
    }
    public static long findMaxButtons (int[] buttons) {
        int n = buttons.length;
        Long[] dp = new Long[n];
        dp[0] = Long.valueOf(buttons[0]);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + 1 + (i+1) * (buttons[i]-1);
        }
        System.out.println(dp[n-1].getClass().getName());
        return dp[n-1];
    }
}

package com.unicorn.Leetcode;

/**
 * <p>
 *     781. 森林中的兔子
 * </p>
 * Created on 2021/04/04 17:05
 *
 * @author Unicorn
 */
public class Solution0781 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,0,0,2};
        System.out.println(numRabbits(arr));

    }
    public static int numRabbits(int[] answers) {
        int length = answers.length;
        if (length == 0) return 0;
        if (length == 1) return answers[0]+1;
        int[] dp = new int[length];
        dp[0] = answers[0] + 1;
        for (int i = 1; i < length; i++) {
            if (answers[i] == 0){
                dp[i] = dp[i-1]+1;
                continue;
            }
            // 在dp中找
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (answers[i] == answers[j]){
                    count++;
                }
            }
            if(count == 0){
                dp[i] = dp[i-1] + answers[i]+1;
            }else if ((count+1) <= answers[i] || (count+1) % (answers[i]+1) != 1){
                // answers中有可抵消的
                dp[i] = dp[i-1];
            }else {
                // answers中没有可抵消的
                dp[i] = dp[i-1] + answers[i]+1;
            }
        }
        return dp[length -1];
    }
}

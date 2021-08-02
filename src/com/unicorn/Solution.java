package com.unicorn;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-31 10:09 上午
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getClass().getClassLoader());
    }

    public int count(int num1, int num2){
        String n1 = String.valueOf(num1);
        String n2 = String.valueOf(num2);

        if (n1.length() > n2.length()){
            for (int i = 0; i < n1.length() - n2.length()+1; i++) {
                n2 = "0"+n2;
            }
            return count(n1, n2);
        }else if (n2.length() > n1.length()){
            for (int i = 0; i < n2.length() - n1.length()+1; i++) {
                n1 = "0" + n1;
            }
            return count(n2, n1);
        }else {
            return count(n1,n2);
        }
    }

    // n1 比较长 n2是比较短的
    public int count(String n1, String n2){
        boolean flag = false;   // 是否需要进位
        int ans = 0;    // 最终进位次数
        for (int i = n1.length()-1; i >= 0; i--) {
            int curSum = (n1.charAt(i) - 48) + (n2.charAt(i) - 48);
            if (flag)   // 上一位相加有进位
            {
                curSum += 1;
                ans++;
            }
            if (curSum >= 10){
                // 需要进位
                flag = true;
            }else {
                flag = false;
            }
        }
        if (flag){
            ans += 1;
        }
        return ans;
    }

}

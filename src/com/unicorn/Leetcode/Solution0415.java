package com.unicorn.Leetcode;

/**
 * <p>
 *     415. 字符串相加
 * </p>
 * Created on 2021/04/02 21:43
 *
 * @author Unicorn
 */
public class Solution0415 {
    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                String s1 = String.valueOf(i);
                String s2 = String.valueOf(j);
                String s3 = String.valueOf(i+j);
                if (!s3.equals(addStrings(s1,s2))){
                    System.out.println(i+"--"+j);
                }
            }
        }
    }
    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder ans = new StringBuilder();
        boolean isCarry = false;
        while (i >= 0 && j >= 0){
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(j) - '0';
            if (isCarry){
                // 需要进位,则当前位结算结果需加1
                if (c1+c2+1 >= 10){
                    isCarry = true;
                    ans.append((c1+c2+1)%10);
                }else {
                    isCarry = false;
                    ans.append(c1+c2+1);
                }
            }else {
                // 不需要进位
                if (c1+c2 >= 10){
                    isCarry = true;
                    ans.append((c1+c2)%10);
                }else {
                    isCarry = false;
                    ans.append(c1+c2);
                }
            }
            i--;j--;
        }

        if (i > j){
            while (i>=0){
                int c1 = num1.charAt(i) - '0';
                if (isCarry){
                    // 需要进位,则当前位结算结果需加1
                    if (c1+1 >= 10){
                        isCarry = true;
                        ans.append((c1+1)%10);
                    }else {
                        isCarry = false;
                        ans.append(c1+1);
                    }
                }else {
                    isCarry = false;
                    ans.append(c1);
                }
                i--;
            }
        }else if (j > i){
            while (j>=0){
                int c1 = num2.charAt(j) - '0';
                if (isCarry){
                    // 需要进位,则当前位结算结果需加1
                    if (c1+1 >= 10){
                        isCarry = true;
                        ans.append((c1+1)%10);
                    }else {
                        isCarry = false;
                        ans.append(c1+1);
                    }
                }else {
                    isCarry = false;
                    ans.append(c1);
                }
                j--;
            }
        }

        if (isCarry){
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}

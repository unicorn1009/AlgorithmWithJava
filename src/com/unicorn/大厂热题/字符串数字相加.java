package com.unicorn.大厂热题;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-22 10:50 上午
 */
public class 字符串数字相加 {
    public static void main(String[] args) {
        String num1 = "3";
        String num2 = "9";
        System.out.println(Integer.parseInt(num1)+Integer.parseInt(num2));
        System.out.println(addStrings(num1, num2));
    }
    public static String addStrings(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        int maxLen = Math.max(num1Len, num2Len);
        StringBuilder ans = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < maxLen; i++) {
            int n1 = 0;
            int n2 = 0;
            int curProd = 0;
            if (i < num1Len)
                n1 = num1.charAt(num1Len-i-1)-48;
            if (i < num2Len)
                n2 = num2.charAt(num2Len-i-1)-48;
            curProd = flag?n1+n2+1:n1+n2;
            flag = curProd >= 10;
            ans.insert(0,curProd%10);
        }
        return flag?ans.insert(0,1).toString():ans.toString();
    }
}

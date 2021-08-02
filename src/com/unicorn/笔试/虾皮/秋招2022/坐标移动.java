package com.unicorn.笔试.虾皮.秋招2022;

import com.unicorn.util.ArrayUtil;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-19 3:06 下午
 */
public class 坐标移动 {
    public static void main(String[] args) {
        ArrayUtil.printArray1D(GetEndPoint("W-20A"));
    }
    public static int[] GetEndPoint(String order) {
        if (order.length() == 0) return new int[]{0,0};
        int[] ans = new int[]{0,0};
        StringBuilder sb = new StringBuilder();
        if (!Character.isDigit(order.charAt(0))){
            sb.append(1);
        }
        for (int i = 0; i < order.length(); i++) {
            if (Character.isLetter(order.charAt(i)) && i-1 >= 0 && !Character.isDigit(order.charAt(i-1))){
                sb.append(1);
                sb.append(order.charAt(i));
            }else {
                sb.append(order.charAt(i));
            }
        }

        order = sb.toString();
        System.out.println(order);

        for (int i = 1; i < order.length(); i++) {
            if (Character.isLetter(order.charAt(i))){
                // 如果是字符, 找前面的数字
                String num = "";
                for (int j = i-1; j >= 0; j--) {
                    if (Character.isDigit(order.charAt(j))){
                        num = order.charAt(j) + num;
                    }else {
                        break;
                    }
                }
                int v = Integer.parseInt(num);
                method(order.charAt(i), v, ans);
            }
        }
        return ans;
    }

    public static void method(char c, int num, int[] ans){
        if (Character.toUpperCase(c) == 'W'){
            ans[1]+=num;
        }else if (Character.toUpperCase(c) == 'S'){
            ans[1] -= num;
        }else if (Character.toUpperCase(c) == 'A'){
            ans[0] -= num;
        }else if (Character.toUpperCase(c) == 'D'){
            ans[0] += num;
        }
    }
}

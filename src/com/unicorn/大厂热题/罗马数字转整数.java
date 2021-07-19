package com.unicorn.大厂热题;

/**
 * <p>
 * </p>
 * Created on 2021-7-19.
 *
 * @author Unicorn
 */
public class 罗马数字转整数 {

    public static void main(String[] args) {

    }

    public int romanToInt (String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I' && (i+1 < s.length() && s.charAt(i+1) == 'V')){
                ans+=4;
                i++;
            }else if (c == 'I' && (i+1 < s.length() && s.charAt(i+1) == 'X')){
                ans+=9;
                i++;
            }else if (c == 'X' && (i+1 < s.length() && s.charAt(i+1) == 'L')) {
                ans+=50;
                i++;
            }else if (c == 'X' && (i+1 < s.length() && s.charAt(i+1) == 'C')){
                ans+=90;
                i++;
            }else if (c == 'C' && (i+1 < s.length() && s.charAt(i+1) == 'D')){
                ans+=500;
                i++;
            }else if (c == 'C' && (i+1 < s.length() && s.charAt(i+1) == 'M')){
                ans+=900;
                i++;
            }else if (c == 'I'){
                ans+=1;
            }else if (c == 'V'){
                ans+=5;
            }else if (c == 'X'){
                ans+=10;
            }else if (c == 'L'){
                ans+=50;
            }else if (c == 'C'){
                ans+=100;
            }else if (c == 'D'){
                ans+=500;
            }else if (c == 'M'){
                ans+=1000;
            }
        }
        return ans;
    }
}

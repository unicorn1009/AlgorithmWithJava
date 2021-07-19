package com.unicorn.Leetcode;

/**
 * <p>
 *     65. 有效数字
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class Solution0065 {
    public static void main(String[] args) {
//        String[] aaa = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
//        for (String s : aaa) {
////            System.out.println(s);
//            Solution0065 solution0065 = new Solution0065();
//            System.out.println(solution0065.isNumber(s));
//        }

        String s = "-e3";
        Solution0065 solution0065 = new Solution0065();
        System.out.println(solution0065.isNumber(s));


    }

    public boolean isNumber(String s) {
        if (s.length()== 0){
            return false;
        }
        s = s.toLowerCase();
        // 有没有+-号, 如果有,一定是第一个字符
        if (s.charAt(0) == '+' || s.charAt(0) == '-'){
            // 有符号, 把符号去除
            s = s.substring(1);
        }
        // 如果只包含正负号
        if (s.length() == 0){
            return false;
        }
        // 此时剩下的字符串最前面应该没有正负号
        // 有没有e
        if (s.contains("e")){
            // 有e, 是科学计数法
            // 只能包含一个e
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'e')
                    count++;
            }
            if (count != 1){
                return false;
            }

            // e前面和后面一定要有数
            if (s.charAt(0) == 'e'){
                return false;
            }
            String[] splitNums = s.split("e");
            if (splitNums.length == 0){
                // 只有e
                return false;
            }else if (splitNums.length == 1){
                return false;
            }else if (splitNums.length == 2){
                // e前面可能是整数或小数
                 if (!isNum(splitNums[0])){
                     return false;
                 }
                // e后面只能是整数, 可能带正负号
                if (splitNums[1].charAt(0) == '+' || splitNums[1].charAt(0) == '-'){
                    // 去除正负号
                    splitNums[1] = splitNums[1].substring(1);
                }
                // 只有正负号
                if (splitNums[1].length() < 1){
                    return false;
                }
                for (int i = 0; i < splitNums[1].length(); i++) {
                    if (!Character.isDigit(splitNums[1].charAt(i))){
                        return false;
                    }
                }
                return true;
            }else {
                return false;
            }

        }else {
            // 没有e, 是一个整数或者小数
            // 此时s应该是一个没有正负号和e的整数或小数
            return isNum(s);
        }
//        return true;
    }


    private boolean isNum(String s){
        if (s.contains(".")){
            // 有小数点, 则当前s是小数
            // 只能有一个小数点
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.')
                    count++;
            }
            if (count != 1){
                return false;
            }
            // 此时s长度至少是2
            if (s.length()<=1){
                return false;
            }
            String[] splitNums = s.split("\\.");
            if (splitNums.length == 0){
                // 表示当前数字只包含.
                return false;
            }else if (splitNums.length == 1){
                for (int i = 0; i < splitNums[0].length(); i++) {
                    if (!Character.isDigit(splitNums[0].charAt(i))){
                        return false;
                    }
                }
                return true;
            }else if (splitNums.length == 2){
                // 小数点.两边都有数字
                for (int i = 0; i < splitNums[0].length(); i++) {
                    if (!Character.isDigit(splitNums[0].charAt(i))){
                        return false;
                    }
                }
                for (int i = 0; i < splitNums[1].length(); i++) {
                    if (!Character.isDigit(splitNums[1].charAt(i))){
                        return false;
                    }
                }
                return true;
            }else {
                // 不止一个小数点
                return false;
            }
        }else {
            // 没有小数点, 则当前s应当是整数
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))){
                    return false;
                }
            }
            return true;
        }
    }
}

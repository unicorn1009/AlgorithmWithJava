package com.unicorn.笔试.虾皮2021秋招;

import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021-7-19.
 *
 * @author Unicorn
 */
public class 字符串命名转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.next();
            System.out.println(caseTransform(input));
        }
    }

    public static String caseTransform(String input){
        if (input.length() == 0) return "";
        if (input.length() == 1) return input.toLowerCase() + " " + input.toUpperCase();
        StringBuilder sb = new StringBuilder();
        // 先统一转成首字母小写形式
        if (input.contains("_")){
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '_' && i+1 < input.length()){
                    sb.append(Character.toUpperCase(input.charAt(i+1)));
                    i++;
                }else {
                    sb.append(input.charAt(i));
                }
            }
        }else if (input.contains("-")){
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '-' && i+1 < input.length()){
                    sb.append(Character.toUpperCase(input.charAt(i+1)));
                    i++;
                }else {
                    sb.append(input.charAt(i));
                }
            }
        } else {
            sb.append(Character.toLowerCase(input.charAt(0)));
            sb.append(input.substring(1));
        }
        String pattern = sb.toString();

        return case0(pattern) + " " + pattern+ " " + case1(pattern)+ " " + case2(pattern);


    }

    public static String case0(String str){
        String sb = Character.toUpperCase(str.charAt(0)) +
                str.substring(1);
        return sb;
    }

    public static String case1(String str){
        StringBuilder sb = new StringBuilder();

        // pascalCaseTest -> pascal_case_test
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 97){
                sb.append("_");
                sb.append(Character.toLowerCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String case2(String str){
        StringBuilder sb = new StringBuilder();

        // pascalCaseTest -> pascal-case-test
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 97){
                sb.append("-");
                sb.append(Character.toLowerCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

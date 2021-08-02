package com.unicorn.笔试.yuanfudao;

import com.unicorn.dataStructure.stageOne.week3.ArrayStack;
import com.unicorn.dataStructure.stageOne.week3.Stack;

/**
 * <p>
 *     [[]3]2 = 8
 *     [][[][][]2]3 = 16
 *     [[][][]2] = 5
 *     [][][]2 = 4
 *     [][][] = 3
 * </p>
 * Created on 2021-7-31.
 *
 * @author Unicorn
 */
public class T3 {
    public static void main(String[] args) {
        String s = "[[][][]2]";
        System.out.println(solution1(s, 0, s.length() - 1));
    }



    public static int solution(String str, int left, int right){
        if (left >= right) return 0;
        if (right - left == 1) return 1;
        // 递归解法
        // 从右向左扫描
        int curBoxNum = 0;
        for (int i = right; i >= left; i--){
            char curChar = str.charAt(i);
            // 找出这个数字对应的两个边界，递归求解
            left = 0;
            right = i;
            int multiple = 1;
            if (Character.isDigit(curChar)) {
                multiple = (curChar - 48);
                right = i-1;
            }
            Stack<Character> stack = new ArrayStack<>();
            for (int j = i; j >= 0; j--){
                // 遇到 ] 就入栈， 栈空时就结束
                if (str.charAt(j) == ']'){
                    stack.push(']');
                }else if (str.charAt(j) == '['){
                    stack.pop();
                    // 出栈后如果栈空， 则找到了左边界
                    if (stack.isEmpty()){
                        left = j;
                        break;
                    }
                }
            }
            if (Character.isDigit(curChar))
                curBoxNum = curBoxNum + multiple*solution(str, left, right);
            else
                curBoxNum = curBoxNum + solution(str, left+1, right-1) + 1;
            // 左右边界之间的处理完成了，i直接跳到左边界前面
            i = left;
        }

        return curBoxNum;
    }




    public static int solution1(String str, int left, int right){
        if (left >= right) return 0;
        if (right - left == 1) return 1;
        // 递归解法
        // 从右向左扫描
        int curBoxNum = 0;
        for (int i = right; i >= left; i--){
            char curChar = str.charAt(i);
            if (Character.isDigit(curChar)){
                // 找出这个数字对应的两个边界，递归求解
                int x = 0, y = i-1;
                Stack<Character> stack = new ArrayStack<>();
                for (int j = i-1; j >= 0; j--){
                    // 遇到 ] 就入栈， 栈空时就结束
                    if (str.charAt(j) == ']'){
                        stack.push(']');
                    }else if (str.charAt(j) == '['){
                        stack.pop();
                        // 出栈后如果栈空， 则找到了左边界
                        if (stack.isEmpty()){
                            x = j;
                            break;
                        }
                    }
                }
                curBoxNum = curBoxNum + (curChar-48)*solution(str, x, y);
                // 左右边界之间的处理完成了，i直接跳到左边界前面
                i = x;
            }else if (curChar == ']'){
                // 当前为右边界， 找出左边界
                int x = 0, y = i;
                Stack<Character> stack = new ArrayStack<>();
                for (int j = i; j >= 0; j--){
                    // 遇到 ] 就入栈， 栈空时就结束
                    if (str.charAt(j) == ']'){
                        stack.push(']');
                    }else if (str.charAt(j) == '['){
                        stack.pop();
                        // 出栈后如果栈空， 则找到了左边界
                        if (stack.isEmpty()){
                            x = j;
                            break;
                        }
                    }
                }
                curBoxNum = curBoxNum + solution(str, x+1, y-1) + 1;
                // 左右边界之间的处理完成了，i直接跳到左边界前面
                i = x;
            }
        }

        return curBoxNum;
    }

}

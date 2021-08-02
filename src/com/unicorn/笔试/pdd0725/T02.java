package com.unicorn.笔试.pdd0725;

import com.unicorn.dataStructure.stageOne.week3.ArrayStack;
import com.unicorn.dataStructure.stageOne.week3.Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-25 7:46 下午
 */
public class T02 {
    public static void main(String[] args) {

    }

    public static void method(Deque<Integer> chicken, Deque<Integer> duck){
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> pai = new ArrayStack<>();
        boolean chi = true; // true则鸡出
        int ji = 0;
        int ya = 0;
        while (!chicken.isEmpty() || !duck.isEmpty()){
            if (chi){
                Integer c = chicken.removeFirst();
                if (!map.containsKey(c)){
                    //牌桌上没有
                    map.put(c, 1);
                    pai.push(c);
                }else {
                    // 牌桌上有
                    map.remove(c);
                    while (!pai.isEmpty() && !pai.peek().equals(c)){
                        ji += pai.pop();
                    }
                    if (!pai.isEmpty() && pai.peek().equals(c)){
                        ji+=pai.pop();
                    }
                    // 需要再出一张
                    Integer c2 = chicken.removeFirst();

                }
            }
        }

    }
}

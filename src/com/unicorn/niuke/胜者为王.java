package com.unicorn.niuke;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/03/18 19:48
 *
 * @author Unicorn
 */
public class 胜者为王 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s1 = in.next();
        String s2 = in.next();
        String s3 = in.next();
        System.out.println(game(n, new String[]{s1, s2, s3}));
//        7
//        treasurehunt
//        threefriends
//        hiCodeforces
    }
    public static String game(int n, String[] strings) {
        int len = strings[0].length();
        HashMap<Character, Integer> ming = new HashMap<>();
        HashMap<Character, Integer> wang = new HashMap<>();
        HashMap<Character, Integer> li = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (ming.containsKey(strings[0].charAt(i))){
                ming.put(strings[0].charAt(i), ming.get(strings[0].charAt(i))+1);
            }else
                ming.put(strings[0].charAt(i), 1);

            if (wang.containsKey(strings[1].charAt(i))){
                wang.put(strings[1].charAt(i), wang.get(strings[1].charAt(i))+1);
            }else
                wang.put(strings[1].charAt(i), 1);

            if (li.containsKey(strings[2].charAt(i))){
                li.put(strings[2].charAt(i), li.get(strings[2].charAt(i))+1);
            }else
                li.put(strings[2].charAt(i), 1);
        }

        int xiaoming = 0;
        int xiaowang = 0;
        int xiaoli = 0;

        for (Integer value : ming.values()) {
            xiaoming = Math.max(xiaoming, value);
        }
        for (Integer value : wang.values()) {
            xiaowang = Math.max(xiaowang, value);
        }
        for (Integer value : li.values()) {
            xiaoli = Math.max(xiaoli, value);
        }



        if (xiaowang > xiaoming && xiaowang > xiaoli) {
            if (Math.max(xiaoming, xiaoli) + n >= len)
                return "draw";
            return "xiaowang";
        }
        if (xiaoming > xiaowang && xiaoming > xiaoli) {
            if (Math.max(xiaowang, xiaoli) + n >= len)
                return "draw";
            return "xiaoming";
        }
        if (xiaoli > xiaoming && xiaoli > xiaowang) {
            if (Math.max(xiaoming, xiaowang) + n >= len)
                return "draw";
            return "xiaoli";
        }

        return "draw";

    }
}

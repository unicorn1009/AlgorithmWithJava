package com.unicorn.mianshijindian.字符串;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class MS0102 {
    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i), 1);
            }else {
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!map.containsKey(s2.charAt(i))){
                return false;
            }
            if (map.get(s2.charAt(i)) == 0){
                return false;
            }
            map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
        }

        Collection<Integer> values = map.values();
        for (Integer value : values) {
            if (value != 0){
                return false;
            }
        }
        return true;
    }
}

package com.unicorn.jzofferll;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *     剑指 Offer II 005. 单词长度的最大乘积
 * </p>
 * Created on 2021-8-11.
 *
 * @author Unicorn
 */
public class JZ005 implements Serializable {
    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        int maxProd = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (!containSameChar(words[i], words[j])){
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    public boolean containSameChar(String word1, String word2){
        boolean[] arr = new boolean[26];
        for (int i = 0; i < word1.length(); i++) {
            arr[word1.charAt(i)-'a'] = true;
        }
        for (int i = 0; i < word2.length(); i++) {
            if (arr[word2.charAt(i) - 'a'])
                return true;
        }
        return false;
    }
}

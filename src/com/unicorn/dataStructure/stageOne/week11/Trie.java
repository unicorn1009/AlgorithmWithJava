package com.unicorn.dataStructure.stageOne.week11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     字典树
 * </p>
 * Created on 2021/3/8.
 *
 * @author Unicorn
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    public Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

}

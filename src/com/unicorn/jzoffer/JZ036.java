package com.unicorn.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/29 14:13
 *
 * @author Unicorn
 */
public class JZ036 {

    // TODO 实现O(1)空间的算法

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private List<Node> nodes;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        nodes = new ArrayList<>();
        dfs(root);
        for (int i = 1; i < nodes.size(); i++) {
            Node n1 = nodes.get(i - 1);
            Node n2 = nodes.get(i);
            n2.left = n1;
            n1.right = n2;
        }
        Node n0 = nodes.get(0);
        Node nn = nodes.get(nodes.size()-1);
        n0.left = nn;
        nn.right = n0;
        return nodes.get(0);
    }

    private void dfs(Node node){
        if (node == null) return;

        dfs(node.left);
        nodes.add(node);
        dfs(node.right);
    }
}

package com.unicorn.mianshijindian.树;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     面试题 04.01. 节点间通路
 *     给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。(图中可能存在自环和平行边。)
 * </p>
 * Created on 2021/7/5.
 *
 * @author Unicorn
 */
public class MS0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (n <= 1)
            return false;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node());
        }
        for (int[] nodePair : graph) {
            nodes.get(nodePair[0]).children.add(nodePair[1]);
        }

        for (Integer curNode : nodes.get(start).children) {
            boolean isArrived = dfs(curNode, target, nodes, n, 1);
            if (isArrived)
                return true;
        }
        return false;
    }

    private boolean dfs(Integer curNode, int target, List<Node> nodes, int n, int num) {
        if (curNode == target){
            return true;
        }

        if (num == n){
            return false;
        }

        for (Integer child : nodes.get(curNode).children) {
            boolean isArrived = dfs(child, target, nodes, n, num+1);
            if (isArrived){
                return true;
            }
        }

        return false;
    }

}

class Node{
    List<Integer> children;

    public Node() {
        this.children = new ArrayList<>();
    }
}

package com.unicorn.笔试.华为0421;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/04/21 19:40
 *
 * @author Unicorn
 */
public class 系统评分 {

    public void score(int[][] dependencies, int M){
        node[] nodes = new node[M];
        for (int i = 0; i < M; i++) {
            nodes[i] = new node(i);
        }
        for (int[] dependency : dependencies) {
            nodes[dependency[0]].dep.add(dependency[1]);
        }
        int count = 0; // 需要扣得分

        // 找无用独立模块
        for (node module : nodes) {
            if (module.dep.size() == 0){
                count++;
                continue;
            }
        }

        // 找环

    }

}

class node{
    int num;
    List<Integer> dep;

    public node(int num){
        this.num = num;
        dep = new ArrayList<>();
    }
}

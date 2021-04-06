package com.unicorn.Leetcode;
/**
 * <p>
 *     1791. 找出星型图的中心节点
 * </p>
 * Created on 2021/04/06 09:53
 *
 * @author Unicorn
 */

public class Solution1791 {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
            return edges[0][0];
        }else
            return edges[0][1];
    }
}

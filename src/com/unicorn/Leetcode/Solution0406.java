package com.unicorn.Leetcode;

import com.unicorn.util.ArrayUtil;

import java.util.*;

/**
 * <p>
 *     406. 根据身高重建队列
 * </p>
 * Created on 2021/03/22 14:44
 *
 * @author Unicorn
 */
public class Solution0406 {

    public static void main(String[] args) {
        int[][] arr = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ret = reconstructQueue(arr);
        System.out.println(ArrayUtil.twoDiemArrayToString(ret));
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 先按people[i][0]身高从高到低排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]){
                    return -1;
                }else if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else {
                    return 1;
                }
            }
        });
        List<int[]> linkedList = new ArrayList<>();

        linkedList.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] < i){
                linkedList.add(people[i][1], people[i]);
            }else {
                linkedList.add(people[i]);
            }
        }

        return linkedList.toArray(people);
    }

}

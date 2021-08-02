package com.unicorn.笔试.虾皮.秋招2021;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021-7-19.
 *
 * @author Unicorn
 */
public class 查找二叉搜索树的叶子节点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String next = sc.nextLine();
            String[] s = next.split(" ");
            int[] pre = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                pre[i] = Integer.parseInt(s[i]);
            }
            PrintLeaves(pre);
        }
    }

    private static Map<Integer, Integer> map;

    public static void PrintLeaves(int[] preOrder){
        // 求出中序
        int[] inOrder = Arrays.copyOf(preOrder, preOrder.length);
        Arrays.sort(inOrder);
        ans = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        boolean[] isVisited = new boolean[preOrder.length];
        int start = 0, end = preOrder.length-1;
        build(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1, isVisited);
        // 打印结果
        for (int i = 0; i < ans.size(); i++) {
            if (i != ans.size()-1){
                System.out.print(ans.get(i) + " ");
            }else {
                System.out.print(ans.get(i));
            }
        }
    }

    private static List<Integer> ans;

    public static void build(int[] preOrder, int preL, int preR,
                             int[] inOrder, int inL, int inR, boolean[] isVisited){

        // 找根
        if (preL > preR || inL > inR) {
            return;
        }
        int curRoot = preOrder[preL];
        Integer pivotIndex = map.get(curRoot);
        isVisited[pivotIndex] = true;
        // 判断当前根在中序中是否有左右节点
        if ((pivotIndex - 1 < 0 || isVisited[pivotIndex-1]) && (pivotIndex+1 > isVisited.length-1 || isVisited[pivotIndex+1])){
            ans.add(curRoot);
        }
        build(preOrder, preL+1, pivotIndex - inL + preL, inOrder, inL, pivotIndex - 1, isVisited);
        build(preOrder, pivotIndex - inL + preL+1, preR, inOrder, pivotIndex + 1, inR, isVisited);
    }


}

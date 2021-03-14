package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     79. 单词搜索
 * </p>
 * Created on 2021/3/11.
 *
 * @author Unicorn
 */
public class Solution0079 {
    public static void main(String[] args) {
        char[][] chars = new char[3][3];
        chars[0] = new char[]{'C','A','A'};
        chars[1] = new char[]{'A','A','A'};
        chars[2] = new char[]{'B','C','D'};

        System.out.println(new Solution0079().exist(chars, "AAB"));
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean[][] flag = new boolean[board.length][board[0].length];
                    // 找到一个可能的起点
                    flag[i][j] = true;  // 标记已走过
                    boolean isOk = dfs(word, 1, new int[]{i, j}, flag, board);
                    if (isOk)
                        return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(String word, int depth, int[] location, boolean[][] flag, char[][] board){
        if (depth == word.length()){
            return true;
        }

        // 遍历周围四个坐标
        //  1. 上
        if (location[0] > 0 && board[location[0] - 1][location[1]] == word.charAt(depth) && !flag[location[0] - 1][location[1]]){
            // 该位置可行
            int i = location[0] - 1, j = location[1];
            flag[i][j] = true; // 标记已走过
            location[0]--;
            boolean isOk = dfs(word, depth+1, location, flag, board);
            // 回溯
            if (!isOk){
                location[0]++;
                flag[i][j] = false;
            }else {
                return true;
            }
        }

        //  1. 下
        if (location[0]+1 < board.length && board[location[0] + 1][location[1]] == word.charAt(depth) && !flag[location[0] + 1][location[1]]){
            // 该位置可行
            int i = location[0] + 1, j = location[1];
            flag[i][j] = true; // 标记已走过
            location[0]++;
            boolean isOk = dfs(word, depth+1, location, flag, board);
            // 回溯
            if (!isOk){
                location[0]--;
                flag[i][j] = false;
            }else {
                return true;
            }
        }

        //  1. 左
        if (location[1] > 0 && board[location[0]][location[1]-1] == word.charAt(depth) && !flag[location[0]][location[1]-1]){
            // 该位置可行
            int i = location[0], j = location[1]-1;
            flag[i][j] = true; // 标记已走过
            location[1]--;
            boolean isOk = dfs(word, depth+1, location, flag, board);
            // 回溯
            if (!isOk){
                location[1]++;
                flag[i][j] = false;
            }else {
                return true;
            }
        }

        //  1. 右
        if (location[1]+1 < board[0].length && board[location[0]][location[1]+1] == word.charAt(depth) && !flag[location[0]][location[1]+1]){
            // 该位置可行
            int i = location[0], j = location[1]+1;
            flag[i][j] = true; // 标记已走过
            location[1]++;
            boolean isOk = dfs(word, depth+1, location, flag, board);
            // 回溯
            if (!isOk){
                location[1]--;
                flag[i][j] = false;
            }else {
                return true;
            }
        }

        return false;

    }


}

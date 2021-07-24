package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *     36. 有效的数独
 * </p>
 * Created on 2021-7-21.
 *
 * @author Unicorn
 */
public class Solution0036 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuffer sbuffer = new StringBuffer();
    }


    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rowSets = new ArrayList<>(9);
        List<HashSet<Integer>> colSets = new ArrayList<>(9);
        List<HashSet<Integer>> gridSets = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>(9));
            colSets.add(new HashSet<>(9));
            gridSets.add(new HashSet<>(9));
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    int curNum = Integer.parseInt(String.valueOf(board[i][j]));
                    int row = i/3, col = j/3;
                    if (rowSets.get(i).contains(curNum) || colSets.get(j).contains(curNum) || gridSets.get(row*3+col).contains(curNum))
                        return false;
                    rowSets.get(i).add(curNum);
                    colSets.get(j).add(curNum);
                    gridSets.get(row*3+col).add(curNum);
                }
            }
        }
        return true;
    }
}

package com.unicorn.mianshijindian.回溯;

import com.unicorn.mianshijindian.动态规划.MS0801;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     面试题 08.04. 幂集
 *     幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *     解集不能包含重复的子集。
 * </p>
 * Created on 2021-7-8.
 *
 * @author Unicorn
 */
public class MS0804 {

    public static void main(String[] args) {
        MS0804 ms0804 = new MS0804();
        List<List<Integer>> subsets = ms0804.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums.length == 0)
            return ans;

        for (int i = 1; i <= nums.length; i++) {
            dfs(nums, 0, i);
        }
        return ans;
    }

    private List<List<Integer>> ans;
    private List<Integer> temp;

    private void dfs(int[] nums, int index, int length){
        if (temp.size() == length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i+1, length);
            temp.remove(temp.size()-1);
        }
    }
}

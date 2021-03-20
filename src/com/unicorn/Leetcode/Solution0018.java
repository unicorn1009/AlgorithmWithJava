package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/19 09:57
 *
 * @author Unicorn
 */
public class Solution0018 {
    public static void main(String[] args) {
//        List<List<Integer>> lists = new ArrayList<>();
//        lists.add(Arrays.asList(new Integer[]{1,2,3,4}));
//        System.out.println(new Solution0018().isContains(lists, new ArrayList<>(Arrays.asList(new Integer[]{1, 4, 3, 1}))));

        System.out.println(new Solution0018().fourSum(new int[]{-483, -476, -475, -460, -450, -431, -428, -419, -410, -374, -347, -345, -311, -303, -299, -286, -278, -271, -260, -257, -240, -227, -217, -203, -196, -191, -189, -179, -171, -151, -150, -144, -134, -130, -112, -107, -97, -96, -94, -70, -62, -54, -38, -38, -23, -12, -11, -2, 2, 4, 30, 33, 38, 51, 51, 54, 69, 90, 108, 111, 112, 112, 121, 129, 163, 182, 184, 194, 198, 199, 210, 228, 229, 232, 236, 237, 249, 249, 259, 282, 303, 312, 317, 329, 329, 342, 349, 368, 375, 380, 384, 393, 420, 433, 441, 446, 460, 474, 497}, -1));
    }

    // 回溯 超时
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int depth = 0;
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, target, depth, ans, path, 0, used, len);
        return ans;
    }

    private void dfs(int[] nums, int target, int depth, List<List<Integer>> ans, List<Integer> path, int index, boolean[] used, int len) {
        if (depth == 4) {
            if (getSum(path) == target) {
                ArrayList<Integer> temp = new ArrayList<>(path);
                if (!isContains(ans, temp))
                    ans.add(temp);
            }

            return;
        }

        for (int i = index; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, target, depth + 1, ans, path, i, used, len);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    private int getSum(List<Integer> num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return sum;
    }

    private boolean isContains(List<List<Integer>> list, List<Integer> nums) {
        nums.sort(Collections.reverseOrder());
        for (List<Integer> integers : list) {
            integers.sort(Collections.reverseOrder());
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (nums.get(i).equals(integers.get(i))) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == 4) {
                return true;
            }

        }
        return false;
    }
}

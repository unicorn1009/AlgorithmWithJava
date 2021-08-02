package com.unicorn.笔试.pdd0725;

import java.util.*;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-25 7:58 下午
 */
public class T022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] ji = new int[n];
            int[] ya = new int[n];
            for (int i = 0; i < n; i++) {
                ji[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                ya[i] = sc.nextInt();
            }
            int[] ans = solution(ji, ya, n);
            System.out.println(ans[0]+" "+ ans[1]);
        }
    }

    private static int[] solution(int[] ji, int[] ya, int n) {
        int[] ans = new int[2];
        int jiIndex = 0;
        int yaIndex = 0;
        Map<Integer, Integer> pai = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        while (jiIndex < n || yaIndex < n){
            if (jiIndex < n){
                jiIndex = turn(pai, nums, ji, n, jiIndex, ans, 0);
                if (jiIndex >= n) continue;
                nums.add(ji[jiIndex]);
                pai.put(ji[jiIndex], nums.size()-1);
                jiIndex++;
            }
            if (yaIndex < n){
                yaIndex = turn(pai, nums, ya, n, yaIndex, ans, 1);
                if (yaIndex >= n) continue;
                nums.add(ya[yaIndex]);
                pai.put(ya[yaIndex], nums.size()-1);
                yaIndex++;
            }
        }
        for (Integer num : nums) {
            if (num % 2 == 0)
                ans[1]+=1;
            else
                ans[0] +=1;
        }
        return ans;
    }

    private static int turn(Map<Integer, Integer> pai, List<Integer> nums, int[] ji, int n, int jiIndex, int[] ans, int pos) {
        // ji
        int a = ji[jiIndex];
        while (pai.containsKey(a)){
            Integer index = pai.get(a);
            int size = nums.size();
            ans[pos] += size-index+1;
            for (int i =size-1; i >= index; i--) {
                pai.remove(nums.get(i));
                nums.remove(i);
            }
            jiIndex++;
            if (jiIndex >= n) break;
            a = ji[jiIndex];
        }
        return jiIndex;
    }
}

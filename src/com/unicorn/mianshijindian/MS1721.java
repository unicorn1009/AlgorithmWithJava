package com.unicorn.mianshijindian;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-04-02 9:35 上午
 */
public class MS1721 {
    public static void main(String[] args) {
        System.out.println(new MS1721().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    boolean isStop = false;
    public int trap(int[] height) {
        int ans = 0;
        while (true){
            int nums = howMuch(height);
            ans += nums;
            if (isStop){
                break;
            }
        }
        return ans;
    }

    private int howMuch(int[] arr){
        int ans = 0;
        int preIndex = -1;
        int numCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0){
                numCount++;
                if (preIndex >= 0){
                    ans += (i-preIndex-1);
                }
                preIndex = i;
                arr[i] -= 1;
            }
        }
        if (numCount <= 1)
            isStop = true;
        return ans;
    }
}

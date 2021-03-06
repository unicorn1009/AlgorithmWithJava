package com.unicorn.jzoffer;

/**
 * <p>
 *      旋转数组的最小数字
 * </p>
 * Created on 2021/2/23.
 *
 * @author Unicorn
 */
public class JZ011 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,1,2,2,2};
        System.out.println(new JZ011().minArray(numbers));
    }
    public int minArray(int[] numbers) {

        return search(numbers, 0, numbers.length - 1);
    }

    private int search(int[] numbers, int l, int r){
        if (numbers[l] < numbers[r]){
            // 区间已排序
            return numbers[l];
        }
        if (l == r) return numbers[l];
        int mid = (l+r)/2;
        if (numbers[mid] > numbers[l]){
            // 中值大于左端点值, 左边排好序
            return search(numbers, mid+1, r);
        }else if (numbers[mid] < numbers[l]){
            // 中值小于左端点值, 目标值在左边
            return search(numbers, l, mid);
        }else {
            // 中值等于左端点值, 左右均需要查找, 取小者
            return Math.min(search(numbers, l, mid), search(numbers, mid+1, r));
        }
    }
}

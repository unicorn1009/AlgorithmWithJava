package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 33. 二叉搜索树的后序遍历序列
 * </p>
 * Created on 2021/03/20 16:26
 *
 * @author Unicorn
 */
public class JZ033 {
    public static void main(String[] args) {
        System.out.println(new JZ033().verifyPostorder(new int[]{1,6,3,2,5}));
    }

    // 递归
    public boolean verifyPostorder(int[] postorder) {
        return isSearchTree(postorder, 0, postorder.length-1);
    }

    private boolean isSearchTree(int[] postorder, int left, int right){
        // 递归边界
        if (right-left <= 1) return true;

        int midNum = postorder[right];
        int mid = right;
        for (int i = left; i < right; i++) {
            if (postorder[i] >= midNum){
                mid = i;
                break;
            }
        }
        for (int i = mid; i < right; i++) {
            if (postorder[i] < midNum)
                return false;
        }

        return isSearchTree(postorder, left, mid-1) && isSearchTree(postorder, mid, right-1);

    }

}

package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *     剑指 Offer 26. 树的子结构
 * </p>
 * Created on 2021/04/05 13:38
 *
 * @author Unicorn
 */
public class JZ026 {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B){
        if (A == null) return false;

        if (A.val == B.val){
            boolean is = isSub(A, B);
            if (is) return true;
        }
        boolean l = isSubStructure(A.left, B);
        if (l) return true;
        return isSubStructure(A.right, B);
    }


    // 传入两棵树, A和B根节点值相等, 返回B是否为A的子树
    public boolean isSub(TreeNode A, TreeNode B) {

        boolean isLeft = true;
        boolean isRight = true;
        if (B.left != null){
            if (A.left != null && A.left.val == B.left.val)
                isLeft = isSub(A.left, B.left);
            else
                isLeft = false;
        }
        if (B.right != null){
            if (A.right != null && A.right.val == B.right.val)
                isRight = isSub(A.right, B.right);
            else
                isRight = false;
        }
        if (isLeft && isRight){
            return true;
        }else {
            return false;
        }

    }
}

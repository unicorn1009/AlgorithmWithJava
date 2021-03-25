package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *     剑指 Offer 55 - II. 平衡二叉树
 *     输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * </p>
 * Created on 2021/03/25 09:56
 *
 * @author Unicorn
 */
public class JZ055_2 {
    public static void main(String[] args) {
        String str = "abc";
        Character a = 'a';
        Character b = new Character('a');
//        System.out.println(a.equals(b));    // T
        System.out.println(a==b);   // F
        System.out.println(a==str.charAt(0));   // T
        System.out.println(b==str.charAt(0));   // T
    }
    public boolean isBalanced(TreeNode root) {
        return false;
    }
}

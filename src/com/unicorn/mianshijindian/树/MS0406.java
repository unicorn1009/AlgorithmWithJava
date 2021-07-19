package com.unicorn.mianshijindian.树;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;

/**
 * <p>
 *     面试题 04.06. 后继者
 * </p>
 * Created on 2021-7-7.
 *
 * @author Unicorn
 */
public class MS0406{

    public static void main(String[] args) {
        MS0406 ms0406 = new MS0406();
        TreeNode treeNode = ms0406.inorderSuccessor(TreeUtil.getTree(new Integer[]{5,3,6,2,4,null,null,1,null}), new TreeNode(1));
        System.out.println(treeNode.val);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ans;
    }

    private TreeNode lastOne;
    private TreeNode ans;

    private void dfs(TreeNode node, TreeNode p){
        if (node == null)
            return;

        dfs(node.left, p);
        if (lastOne == p && ans == null){
            ans = node;
            return;
        }
        lastOne = node;
        dfs(node.right, p);
    }

}

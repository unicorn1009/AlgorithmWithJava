package com.unicorn.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 *     二叉树的最小深度
 * </p>
 * Created on 2021-7-29.
 *
 * @author Unicorn
 */
public class Solution0111 {
    public static void main(String[] args) {

    }


    // BFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        // 初试深度设为1
        int depth = 1;
        while (!queue.isEmpty()){
            // 当前所在层有多少个节点
            int curLevelNodeNum = queue.size();;
            for (int i = 0; i < curLevelNodeNum; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            // 出完一层, 深度++
            depth++;
        }
        return depth;
    }
}

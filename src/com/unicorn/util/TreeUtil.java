package com.unicorn.util;

import com.unicorn.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * </p>
 * Created on 2021/3/17
 *
 * @author Unicorn
 */
public class TreeUtil {
    public static void main(String[] args) {

    }

    public static TreeNode cloneTree(TreeNode root){
        TreeNode node=null;
        if(root==null) return null;
        node=new TreeNode(root.val);
        node.left=cloneTree(root.left);
        node.right=cloneTree(root.right);

        return node;
    }

    /**
     * 根据给定列表, 生成一颗完全二叉树
     * @param root 根节点
     * @param list 给定列表
     */
    public static void genCompleteBTree(TreeNode root, List<Integer> list) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty() && count < list.size()) {
            TreeNode lastNode = queue.poll();

            if (count < list.size()) {
                TreeNode left = new TreeNode(list.get(count++));
                lastNode.left = left;
                queue.add(left);
            }
            if (count < list.size()) {

                TreeNode right = new TreeNode(list.get(count++));
                lastNode.right = right;
                queue.add(right);
            }
        }
    }

    /**
     * 根据给定列表, 生成一颗完全二叉树
     * @param arr 给定列表
     * @return  完全二叉树
     */
    public static TreeNode genCompleteBTree(int[] arr) {
        if(arr.length == 1) {
            return new TreeNode(arr[0]);
        }
        List<TreeNode> nodeList = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            nodeList.add(new TreeNode(arr[i]));
        }
        int temp = 0;
        while(temp <= (arr.length - 2) / 2) {  //注意这里，数组的下标是从零开始的
            if(2 * temp + 1 < arr.length) {
                nodeList.get(temp).left = nodeList.get(2 * temp + 1);
            }
            if(2 * temp + 2 < arr.length) {
                nodeList.get(temp).right = nodeList.get(2 * temp + 2);
            }
            temp++;
        }
        return nodeList.get(0);
    }

    /**
     * 对树先序遍历
     * @param root 树根
     */
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 对树中序遍历
     * @param root 树根
     */
    public static void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 对树后序遍历
     * @param root 树根
     */
    public static void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 对树层序遍历
     * @param root 树根
     */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            System.out.println(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

    }


    // 用于获得树的层数
    private static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }


    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void showTree(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static TreeNode getTree(Integer[] a){
        int i=1;
        TreeNode root = new TreeNode(a[0]);  // 根节点
        TreeNode current = null;
        Integer value = null;

        //层序创建二叉树
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(i<a.length) {
            current = queue.poll();//从链表中移除并获取第一个节点
            value = a[i++];
            if(value!=null) {
                TreeNode left =new TreeNode(value);
                current.left = left;
                queue.offer(left); // 在链表尾部 左孩子入队
            }
            value=a[i++];
            if(value!=null) {
                TreeNode right =new TreeNode(value);
                current.right = right;
                queue.offer(right);// 在链表尾部 右孩子入队
            }

        }
        return root;
    }

}

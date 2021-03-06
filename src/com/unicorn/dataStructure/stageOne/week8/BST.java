package com.unicorn.dataStructure.stageOne.week8;

import java.util.*;

/**
 * <p>
 *     二叉搜索数
 * </p>
 * Created on 2021/2/26.
 *
 * @author Unicorn
 */
public class BST {

    public static void main(String[] args) {
        System.out.println("===========层序遍历==========");
        BST bst = new BST();
        int[] arr = {5, 3, 2, 6, 4, 5, 8};
        for (int i : arr) {
            bst.add(i);
        }
        bst.levelOrder();

        System.out.println("===========删除二叉搜索树最小值==========");
        BST bst1 = new BST();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst1.add(random.nextInt(1000));
        }
        while (!bst1.isEmpty()){
            int min = bst1.removeMin();
            System.out.println(min);
        }

    }

    public Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int v){
        root = add(root, v);
    }

    private Node add(Node node, int v) {
        if (node == null){
            size++;
            return new Node(v);
        }
        if ( v < node.v)
            node.left = add(node.left, v);
        else if (v > node.v)
            node.right = add(node.right, v);

        return node;
    }

    public boolean contains(int v){
        return contains(root, v);
    }

    private boolean contains(Node node, int v) {
        if (node == null)
            return false;

        if (node.v == v)
            return true;
        else if (v > node.v)
            return contains(node.right, v);
        else
            return contains(node.left, v);
    }

    // 树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.v);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 树的前序遍历 : 非递归写法
    public void preOrderNR(){
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node popNode = stack.pop();
            System.out.println(popNode.v);
            if (popNode.right != null)
                stack.push(popNode.right);
            if (popNode.left != null)
                stack.push(popNode.left);
        }
    }

    // 二叉搜索树的中序遍历 : 特点: 叉搜索树的中序遍历输出是有序的
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.v);
        inOrder(node.right);
    }

    // 树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.v);
    }

    // 树的广度优先遍历 : 层序遍历
    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){

            Node cur = queue.remove();
            System.out.println(cur.v);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

        }

    }

    // 返回二叉搜索树中的最小值
    public int minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty!");

        return minimum(root).v;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 返回二叉搜索树中的最大值
    public int maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty!");

        return maximum(root).v;
    }

    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return minimum(node.right);
    }


    // 删除二叉搜索树中的最小值节点, 返回该最小值
    public int removeMin(){
        int minimum = minimum();
        root = removeMin(root);
        return minimum;
    }

    // 删除以node结点为根的二叉搜索树的最小值, 返回删除后的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node temp = node.right;
            node.right = null;
            size--;
            return temp;
        }

        node.left = removeMin(node.left);
        return node;

    }

    public int removeMax(){
        int maximum = maximum();
        root = removeMax(root);
        return maximum;
    }

    // 删除以node结点为根的二叉搜索树的最小值, 返回删除后的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node temp = node.left;
            node.left = null;
            size--;
            return temp;
        }

        node.right = removeMax(node.right);
        return node;

    }
}

package com.cenfotec.Entities;

public class TreeNode {
    protected int value;
    protected TreeNode leftNode;
    protected TreeNode rightNode;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}

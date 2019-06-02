package com.cenfotec.Entities.Trees.Nodes;

public class BinaryNode {
    private int value;
    private BinaryNode leftNode;
    private BinaryNode rightNode;

    public BinaryNode() {
    }

    public BinaryNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinaryNode(int value, BinaryNode leftNode, BinaryNode rightNode) {
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

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }
}

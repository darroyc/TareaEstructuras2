package com.cenfotec.Entities.Trees.Nodes;

public class AVLNode {
    private AVLNode left, right;
    private int value;
    private int height;

    /* Constructor */
    public AVLNode()
    {
        left = null;
        right = null;
        value = 0;
        height = 0;
    }
    /* Constructor */
    public AVLNode(int n)
    {
        left = null;
        right = null;
        value = n;
        height = 0;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int data) {
        this.value = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

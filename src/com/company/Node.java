package com.company;

public class Node {
    private int value;
    private Node nextNode;
    private Node previousNode;

    public Node() {
        this.value = 0;
        this.nextNode = null;
        this.previousNode = null;
    }

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
        this.previousNode = null;
    }

    public Node(int value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public Node(int value, Node nextNode, Node previousNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Node getNextNode() {
        return nextNode;
    }

    protected void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    protected Node getPreviousNode() { return previousNode; }

    protected void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
}

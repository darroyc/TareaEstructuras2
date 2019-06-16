package com.cenfotec.Entities.LinearStructures;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;
    private Node<T> previousNode;

    public Node() {
        this.data = null;
        this.nextNode = null;
        this.previousNode = null;
    }

    public Node(T data) {
        this.data = data;
        this.nextNode = null;
        this.previousNode = null;
    }

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(T data, Node<T> nextNode, Node<T> previousNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    protected Node<T> getNextNode() {
        return nextNode;
    }

    protected void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    protected Node<T> getPreviousNode() { return previousNode; }

    protected void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }
}

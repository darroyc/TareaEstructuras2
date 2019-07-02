package com.cenfotec.Entities.Trees.Nodes;

public class RedBlackNode <Key extends Comparable<Key>, Value>{
    public Key key;           // key
    public Value val;         // associated data
    public RedBlackNode left, right;  // links to left and right subtrees
    public boolean color;     // color of parent link
    public int size;          // subtree count

    public RedBlackNode(Key key, Value val, boolean color, int size) {
        this.key = key;
        this.val = val;
        this.color = color;
        this.size = size;
    }
}

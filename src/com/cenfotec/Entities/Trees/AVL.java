package com.cenfotec.Entities.Trees;

import com.cenfotec.Entities.Trees.Nodes.AVLNode;

public class AVL {
    private AVLNode root;

    /* Constructor */
    public AVL()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Make the tree logically empty */
    public void clear()
    {
        root = null;
    }
    /* Function to insert data */
    public void insert(int data)
    {
        root = insert(data, root);
    }
    /* Function to get getHeight() of node */
    private int height(AVLNode avlNode )
    {
        return avlNode == null ? -1 : avlNode.getHeight();
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    /* Function to insert data recursively */
    private AVLNode insert(int value, AVLNode avlNode)
    {
        if (avlNode == null)
            avlNode = new AVLNode(value);
        else if (value < avlNode.getValue())
        {
            avlNode.setLeft(insert( value, avlNode.getLeft() ));
            if( height(avlNode.getLeft()) - height( avlNode.getRight() ) == 2 )
                if( value < avlNode.getLeft().getValue() )
                    avlNode = rotateWithLeftChild( avlNode );
                else
                    avlNode = doubleWithLeftChild( avlNode );
        }
        else if( value > avlNode.getValue() )
        {
            avlNode.setRight(insert( value, avlNode.getRight() ));
            if( height( avlNode.getRight() ) - height(avlNode.getLeft()) == 2 )
                if( value > avlNode.getRight().getValue())
                    avlNode = rotateWithRightChild( avlNode );
                else
                    avlNode = doubleWithRightChild( avlNode );
        }
        avlNode.setHeight(max( height(avlNode.getLeft()), height( avlNode.getRight() ) ) + 1);
        return avlNode;
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode node2)
    {
        AVLNode node1 = node2.getLeft();
        node2.setLeft(node1.getRight());
        node1.setRight(node2);
        node2.setHeight(max( height(node2.getLeft()), height(node2.getRight()) ) + 1);
        node1.setHeight(max( height(node1.getLeft()), node2.getHeight() ) + 1);
        return node1;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode node1)
    {
        AVLNode node2 = node1.getRight();
        node1.setRight(node2.getLeft());
        node2.setLeft(node1);
        node1.setHeight(max( height( node1.getLeft() ), height( node1.getRight() ) ) + 1);
        node2.setHeight(max( height( node2.getRight() ), node1.getHeight() ) + 1);
        return node2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node node3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode node3)
    {
        node3.setLeft(rotateWithRightChild( node3.getLeft() ));
        return rotateWithLeftChild( node3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node node1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode node1)
    {
        node1.setRight(rotateWithLeftChild( node1.getRight() ));
        return rotateWithRightChild( node1 );
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(AVLNode avlNode)
    {
        if (avlNode == null)
            return 0;
        else
        {
            int nodeCount = 1;
            nodeCount += countNodes(avlNode.getLeft());
            nodeCount += countNodes(avlNode.getRight());
            return nodeCount;
        }
    }
    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    private boolean search(AVLNode avlNode, int val)
    {
        boolean found = false;
        while ((avlNode != null) && !found)
        {
            int rval = avlNode.getValue();
            if (val < rval)
                avlNode = avlNode.getLeft();
            else if (val > rval)
                avlNode = avlNode.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(avlNode, val);
        }
        return found;
    }

    public String inOrder(){
        return deleteLastComma(inOrder(root));
    }

    public String preOrder(){
        return deleteLastComma(preOrder(root));
    }

    public String postOrder(){
        return deleteLastComma(postOrder(root));
    }

    private String inOrder(AVLNode v_node){
        String content = "";
        if(v_node != null){
            content += inOrder(v_node.getLeft());
            content += "[" +v_node.getValue()+"],";
            content += inOrder(v_node.getRight());
        }
        return content;
    }

    private String preOrder(AVLNode v_node){
        String content = "";
        if(v_node != null){
            content += "[" +v_node.getValue()+"],";
            content += preOrder(v_node.getLeft());
            content += preOrder(v_node.getRight());
        }
        return content;
    }

    private String postOrder(AVLNode v_node){
        String content = "";
        if(v_node != null){
            content += postOrder(v_node.getLeft());
            content += postOrder(v_node.getRight());
            content += "[" +v_node.getValue()+"],";
        }
        return content;
    }

    private String deleteLastComma(String content){
        if(content.contains(",")){
            return content.substring(0, content.length()-1);
        }
        return content;
    }
}

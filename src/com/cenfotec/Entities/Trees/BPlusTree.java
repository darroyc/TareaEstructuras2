package com.cenfotec.Entities.Trees;

import com.cenfotec.Entities.Trees.Nodes.BPlusInnerNode;
import com.cenfotec.Entities.Trees.Nodes.BPlusLeafNode;
import com.cenfotec.Entities.Trees.Nodes.BPlusNode;
import com.cenfotec.Enums.BTreeNodeType;

/**
 * A B+ tree
 * Since the structures and behaviors between internal node and external node are different,
 * so there are two different classes for each kind of node.
 * @param <TKey> the data type of the key
 * @param <TValue> the data type of the value
 */
public class BPlusTree<TKey extends Comparable<TKey>, TValue> {
    private BPlusNode<TKey> root;

    public BPlusTree() {
        this.root = new BPlusLeafNode<TKey, TValue>();
    }

    /**
     * Insert a new key and its associated value into the B+ tree.
     */
    public void insert(TKey key, TValue value) {
        BPlusLeafNode<TKey, TValue> leaf = this.findLeafNodeKey(key);
        leaf.insertKey(key, value);

        if (leaf.isOverflow()) {
            BPlusNode<TKey> n = leaf.dealOverflow();
            if (n != null)
                this.root = n;
        }
    }

    /**
     * Search a key value on the tree and return its associated value.
     */
    public TValue search(TKey key) {
        BPlusLeafNode<TKey, TValue> leaf = this.findLeafNodeKey(key);

        int index = leaf.search(key);
        return (index == -1) ? null : leaf.getValue(index);
    }

    /**
     * Delete a key and its associated value from the tree.
     */
    public void delete(TKey key) {
        BPlusLeafNode<TKey, TValue> leaf = this.findLeafNodeKey(key);

        if (leaf.delete(key) && leaf.isUnderflow()) {
            BPlusNode<TKey> n = leaf.dealUnderflow();
            if (n != null)
                this.root = n;
        }
    }

    /**
     * Search the leaf node which should contain the specified key
     */
    @SuppressWarnings("unchecked")
    private BPlusLeafNode<TKey, TValue> findLeafNodeKey(TKey key) {
        BPlusNode<TKey> node = this.root;
        while (node.getNodeType() == BTreeNodeType.InnerNode) {
            node = ((BPlusInnerNode<TKey>)node).getChild( node.search(key) );
        }

        return (BPlusLeafNode<TKey, TValue>)node;
    }
}
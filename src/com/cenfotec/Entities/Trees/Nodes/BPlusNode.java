package com.cenfotec.Entities.Trees.Nodes;


import com.cenfotec.Enums.BTreeNodeType;

public abstract class BPlusNode<TKey extends Comparable<TKey>> {
    protected Object[] keys;
    protected int keyCount;
    protected BPlusNode<TKey> parentNode;
    protected BPlusNode<TKey> leftSibling;
    protected BPlusNode<TKey> rightSibling;


    protected BPlusNode() {
        this.keyCount = 0;
        this.parentNode = null;
        this.leftSibling = null;
        this.rightSibling = null;
    }

    public int getKeyCount() {
        return this.keyCount;
    }

    @SuppressWarnings("unchecked")
    public TKey getKey(int index) {
        return (TKey)this.keys[index];
    }

    public void setKey(int index, TKey key) {
        this.keys[index] = key;
    }

    public BPlusNode<TKey> getParent() {
        return this.parentNode;
    }

    public void setParent(BPlusNode<TKey> parent) {
        this.parentNode = parent;
    }

    public abstract BTreeNodeType getNodeType();


    /**
     * Search a key on current node, if found the key then return its position,
     * otherwise return -1 for a leaf node,
     * return the child node index which should contain the key for a internal node.
     */
    public abstract int search(TKey key);



    /* The codes below are used to support insertion operation */

    public boolean isOverflow() {
        return this.getKeyCount() == this.keys.length;
    }

    public BPlusNode<TKey> dealOverflow() {
        int midIndex = this.getKeyCount() / 2;
        TKey upKey = this.getKey(midIndex);

        BPlusNode<TKey> newRNode = this.split();

        if (this.getParent() == null) {
            this.setParent(new BPlusInnerNode<TKey>());
        }
        newRNode.setParent(this.getParent());

        // maintain links of sibling nodes
        newRNode.setLeftSibling(this);
        newRNode.setRightSibling(this.rightSibling);
        if (this.getRightSibling() != null)
            this.getRightSibling().setLeftSibling(newRNode);
        this.setRightSibling(newRNode);

        // push up a key to parent internal node
        return this.getParent().pushUpKey(upKey, this, newRNode);
    }

    protected abstract BPlusNode<TKey> split();

    protected abstract BPlusNode<TKey> pushUpKey(TKey key, BPlusNode<TKey> leftChild, BPlusNode<TKey> rightNode);

    /* The codes below are used to support deletion operation */

    public boolean isUnderflow() {
        return this.getKeyCount() < (this.keys.length / 2);
    }

    public boolean canLendAKey() {
        return this.getKeyCount() > (this.keys.length / 2);
    }

    public BPlusNode<TKey> getLeftSibling() {
        if (this.leftSibling != null && this.leftSibling.getParent() == this.getParent())
            return this.leftSibling;
        return null;
    }

    public void setLeftSibling(BPlusNode<TKey> sibling) {
        this.leftSibling = sibling;
    }

    public BPlusNode<TKey> getRightSibling() {
        if (this.rightSibling != null && this.rightSibling.getParent() == this.getParent())
            return this.rightSibling;
        return null;
    }

    public void setRightSibling(BPlusNode<TKey> silbling) {
        this.rightSibling = silbling;
    }

    public BPlusNode<TKey> dealUnderflow() {
        if (this.getParent() == null)
            return null;

        // try to borrow a key from sibling
        BPlusNode<TKey> leftSibling = this.getLeftSibling();
        if (leftSibling != null && leftSibling.canLendAKey()) {
            this.getParent().processChildrenTransfer(this, leftSibling, leftSibling.getKeyCount() - 1);
            return null;
        }

        BPlusNode<TKey> rightSibling = this.getRightSibling();
        if (rightSibling != null && rightSibling.canLendAKey()) {
            this.getParent().processChildrenTransfer(this, rightSibling, 0);
            return null;
        }

        // Can not borrow a key from any sibling, then do fusion with sibling
        if (leftSibling != null) {
            return this.getParent().processChildrenFusion(leftSibling, this);
        }
        else {
            return this.getParent().processChildrenFusion(this, rightSibling);
        }
    }

    protected abstract void processChildrenTransfer(BPlusNode<TKey> borrower, BPlusNode<TKey> lender, int borrowIndex);

    protected abstract BPlusNode<TKey> processChildrenFusion(BPlusNode<TKey> leftChild, BPlusNode<TKey> rightChild);

    protected abstract void fusionWithSibling(TKey sinkKey, BPlusNode<TKey> rightSibling);

    protected abstract TKey transferFromSibling(TKey sinkKey, BPlusNode<TKey> sibling, int borrowIndex);
}
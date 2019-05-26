package com.cenfotec.Entities;


public class Stack extends BaseStructure {

    public Stack() {
        setHead(null);
    }

    public void push(int value)
    {
        Node newNode;
        newNode = new Node(value);

        if (isEmpty()) {
            setHead(newNode);
        } else {
            newNode.setNextNode(getHead());
            setHead(newNode);
        }
    }

    public Integer pop()
    {
        if (!isEmpty())
        {
            Node currentHead = getHead();
            if (currentHead.getNextNode()==null){
                setHead(null);
            } else {
                setHead(currentHead.getNextNode());
            }
            return currentHead.getValue();
        } else {
            return null;
        }
    }


}

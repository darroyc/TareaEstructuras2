package com.cenfotec.Entities;


public class Queue extends BaseStructure {
    private Node last;

    public Queue() {
        setHead(null);
        last =null;
    }

    public void push(int value)
    {
        Node newNode;
        newNode = new Node(value);

        if (isEmpty()) {
            setHead(newNode);
            last = newNode;
        } else {
            last.setNextNode(newNode);
            last = newNode;
        }
    }

    public Integer pop()
    {
        if (!isEmpty())
        {
            int value = getHead().getValue();
            if (getHead() == last){
                setHead(null);
                last = null;
            } else {
                setHead(getHead().getNextNode());
            }
            return value;
        } else {
            return null;
        }
    }


}

package com.cenfotec.Entities.LinearStructures;


public class Stack <T extends Comparable<T>> extends Base<T> {

    public Stack() {
        setHead(null);
    }

    public void push(T value)
    {
        Node<T> newNode;
        newNode = new Node<T>(value);

        if (isEmpty()) {
            setHead(newNode);
        } else {
            newNode.setNextNode(getHead());
            setHead(newNode);
        }
    }

    public T pop()
    {
        if (!isEmpty())
        {
            Node<T> currentHead = getHead();
            if (currentHead.getNextNode()==null){
                setHead(null);
            } else {
                setHead(currentHead.getNextNode());
            }
            return currentHead.getData();
        } else {
            return null;
        }
    }


}

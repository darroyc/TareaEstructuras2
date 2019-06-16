package com.cenfotec.Entities.LinearStructures;


public class Queue<T extends Comparable<T>> extends Base<T> {
    private Node<T> last;

    public Queue() {
        setHead(null);
        last =null;
    }

    public void push(T value)
    {
        Node<T> newNode;
        newNode = new Node<>(value);

        if (isEmpty()) {
            setHead(newNode);
            last = newNode;
        } else {
            last.setNextNode(newNode);
            last = newNode;
        }
    }

    public T pop()
    {
        if (!isEmpty())
        {
            var value = getHead().getData();
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

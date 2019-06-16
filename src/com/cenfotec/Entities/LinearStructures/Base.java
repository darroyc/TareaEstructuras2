package com.cenfotec.Entities.LinearStructures;

public abstract class Base<T extends Comparable<T>> {
    protected Node<T> head;

    public Node<T> getHead(){
        return head;
    }

    public void setHead(Node<T> head){
        this.head = head;
    }

    public abstract void push(T data);

    public abstract T pop();

    public String getContent(){
        if(!isEmpty()){
            Node tempNode = getHead();
            String content = "";
            StringBuilder stringBuilder = new StringBuilder();
            while (tempNode!=null){
                stringBuilder.append(tempNode.getData()).append(", ");
                tempNode = tempNode.getNextNode();
            }
            content = stringBuilder.toString();
            return "["+content.substring(0, content.length()-2) + "]";
        }else{
            return "La estructura esta vacia";
        }
    }

    protected int getSize(){
        int counter = 0;
        if(!isEmpty()){
            Node tempNode = getHead();
            while (tempNode!=null){
                tempNode = tempNode.getNextNode();
                counter++;
            }
        }
        return counter;
    }

    protected boolean isEmpty(){
        return getHead()==null;
    }
}

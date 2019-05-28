package com.cenfotec.Entities;

public abstract class BaseStructure extends Node {
    private Node head;

    public Node getHead(){
        return head;
    }

    public void setHead(Node head){
        this.head = head;
    }

    public abstract void push(int value);

    public abstract Integer pop();

    public String getContent(){
        if(!isEmpty()){
            Node tempNode = getHead();
            String content = "";
            StringBuilder stringBuilder = new StringBuilder();
            while (tempNode!=null){
                stringBuilder.append(tempNode.getValue()).append(", ");
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

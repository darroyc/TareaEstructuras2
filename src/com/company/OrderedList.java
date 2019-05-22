package com.company;

public class OrderedList extends Node {
    private Node head;

    public OrderedList() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(int value){
        Node node = new Node(value);
        if(isEmpty()){
            setHead(node);
        }else{
            Node tempNode = getHead();
            if(tempNode.getValue()<node.getValue()){
                node.setPreviousNode(tempNode);
                setHead(node);
                tempNode.setNextNode(node);
            }else{
                while(tempNode.getPreviousNode() != null && tempNode.getPreviousNode().getValue()>node.getValue()){
                    tempNode = tempNode.getPreviousNode();
                }
                if(tempNode.getPreviousNode() != null){
                    node.setPreviousNode(tempNode.getPreviousNode());
                    tempNode.getPreviousNode().setNextNode(node);
                }
                tempNode.setPreviousNode(node);
                node.setNextNode(tempNode);
            }
        }
    }

    public void remove(int value){
        if(!isEmpty()){
            Node tempNode = getHead();
            while(tempNode.getValue()!=value){
                tempNode = tempNode.getPreviousNode();
            }
            if(getSize()==1){
                setHead(null);
            }else{
                if(getHead().getValue()==value){
                    setHead(getHead().getPreviousNode());
                    getHead().setNextNode(null);
                }else{
                    tempNode.getNextNode().setPreviousNode(tempNode.getPreviousNode());
                    if(tempNode.getPreviousNode()!=null){
                        tempNode.getPreviousNode().setNextNode(tempNode.getNextNode());
                    }
                }
            }
            System.gc();
        }
    }

    public String getContent(){
        if(!isEmpty()){
            Node tempNode = getHead();
            String content = "";
            StringBuilder stringBuilder = new StringBuilder();
            while (tempNode!=null){
                stringBuilder.append(tempNode.getValue()).append(", ");
                tempNode = tempNode.getPreviousNode();
            }
            content = stringBuilder.toString();
            return "["+content.substring(0, content.length()-2) + "]";
        }else{
            return "La lista esta vacia";
        }
    }

    public int getSize(){
        int counter = 0;
        if(!isEmpty()){
            Node tempNode = getHead();
            while (tempNode!=null){
                tempNode = tempNode.getPreviousNode();
                counter++;
            }
        }
        return counter;
    }

    public boolean isEmpty(){
        return getHead()==null;
    }
}

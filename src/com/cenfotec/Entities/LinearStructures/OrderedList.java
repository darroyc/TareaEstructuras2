package com.cenfotec.Entities.LinearStructures;

public class OrderedList extends Base {
    private Node head;

    public OrderedList() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void push(int value){
        Node node = new Node(value);
        if(isEmpty()){
            setHead(node);
        }else{
            Node tempNode = getHead();
            if(tempNode.getValue()<node.getValue()){
                node.setNextNode(tempNode);
                setHead(node);
                tempNode.setPreviousNode(node);
            }else{
                while(tempNode.getNextNode() != null && tempNode.getNextNode().getValue()>node.getValue()){
                    tempNode = tempNode.getNextNode();
                }
                if(tempNode.getNextNode() != null){
                    node.setNextNode(tempNode.getNextNode());
                    tempNode.getNextNode().setPreviousNode(node);
                }
                tempNode.setNextNode(node);
                node.setPreviousNode(tempNode);
            }
        }
    }

    public Integer pop(){
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

    public Integer pop(int value){
        if(!isEmpty()){
            Node tempNode = getHead();
            while(tempNode.getValue()!=value){
                tempNode = tempNode.getNextNode();
            }
            if(getSize()==1){
                setHead(null);
            }else{
                if(getHead().getValue()==value){
                    setHead(getHead().getNextNode());
                    getHead().setPreviousNode(null);
                }else{
                    tempNode.getPreviousNode().setNextNode(tempNode.getNextNode());
                    if(tempNode.getNextNode()!=null){
                        tempNode.getNextNode().setPreviousNode(tempNode.getPreviousNode());
                    }
                }
            }
            return tempNode.getValue();
        }
        return null;
    }
}

package com.cenfotec.Entities.LinearStructures;

public class OrderedList<T extends Comparable<T>> extends Base<T> {

    public OrderedList() {
    }

    public void push(T data) {
        var node = new Node<T>(data);
        if (isEmpty()) {
            setHead(node);
        } else {
            Node<T> tempNode = getHead();
            if (tempNode.getData().compareTo(node.getData()) < 0) {
                node.setNextNode(tempNode);
                setHead(node);
                tempNode.setPreviousNode(node);
            } else {
                while (tempNode.getNextNode() != null && tempNode.getNextNode().getData().compareTo(node.getData()) > 0) {
                    tempNode = tempNode.getNextNode();
                }
                if (tempNode.getNextNode() != null) {
                    node.setNextNode(tempNode.getNextNode());
                    tempNode.getNextNode().setPreviousNode(node);
                }
                tempNode.setNextNode(node);
                node.setPreviousNode(tempNode);
            }
        }
    }

    public T pop(){
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

    public T pop(T value){
        if(!isEmpty()){
            Node<T> tempNode = getHead();
            while(tempNode.getData().compareTo(value)!=0){
                tempNode = tempNode.getNextNode();
            }
            if(getSize()==1){
                setHead(null);
            }else{
                if(getHead().getData().compareTo(value) == 0){
                    setHead(getHead().getNextNode());
                    getHead().setPreviousNode(null);
                }else{
                    tempNode.getPreviousNode().setNextNode(tempNode.getNextNode());
                    if(tempNode.getNextNode()!=null){
                        tempNode.getNextNode().setPreviousNode(tempNode.getPreviousNode());
                    }
                }
            }
            return tempNode.getData();
        }
        return null;
    }
}

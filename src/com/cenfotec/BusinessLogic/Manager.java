package com.cenfotec.BusinessLogic;

import com.cenfotec.Entities.LinearStructures.Base;
import com.cenfotec.Entities.LinearStructures.OrderedList;
import com.cenfotec.Entities.LinearStructures.Queue;
import com.cenfotec.Entities.LinearStructures.Stack;
import com.cenfotec.Entities.Trees.AVL;
import com.cenfotec.Entities.Trees.Binary;
import com.cenfotec.Enums.Structure;

public class Manager {
    private Stack stack;
    private Queue queue;
    private OrderedList orderedList;
    private Binary binaryTree;
    private AVL avlTree;

    public Manager(){
        stack = new Stack();
        queue = new Queue();
        orderedList = new OrderedList();
        binaryTree = new Binary();
        avlTree = new AVL();
    }

    public void push(int value, Structure structure){
        switch (structure) {
            case STACK:
                stack.push(value);
                break;
            case QUEUE:
                queue.push(value);
                break;
            case LIST:
                orderedList.push(value);
                break;
            case BINARY:
                binaryTree.insert(value);
                break;
            case AVL:
                avlTree.insert(value);
                break;
        }
    }

    public Integer pop(Structure structure){
        Integer value = 0;
        switch (structure) {
            case STACK:
                value = stack.pop();
                break;
            case QUEUE:
                value = queue.pop();
                break;
            case LIST:
                value = orderedList.pop();
                break;
        }
        return value;
    }

    public Integer deleteFromList(int value){
        return orderedList.pop(value);
    }

    public Structure convert(Structure newStructure, Structure currentStructure){
        switch (newStructure) {
            case STACK:
                switch (currentStructure) {
                    case QUEUE:
                        pass(queue, stack);
                        break;
                    case LIST:
                        pass(orderedList, stack);
                        break;
                }
                break;
            case QUEUE:
                switch (currentStructure) {
                    case STACK:
                        pass(stack, queue);
                        break;
                    case LIST:
                        pass(orderedList, queue);
                        break;
                }
                break;
            case LIST:
                switch (currentStructure) {
                    case STACK:
                        pass(stack, orderedList);
                        break;
                    case QUEUE:
                        pass(queue, orderedList);
                        break;
                }
                break;
        }
        return newStructure;
    }

    private void pass(Base oldStructure, Base newStructure){
        Integer value = oldStructure.pop();
        while (value!=null){
            newStructure.push(value);
            value = oldStructure.pop();
        }
    }

    public String getStructureContent(Structure structure){
        String content;
        switch (structure) {
            case STACK:
                return stack.getContent();
            case QUEUE:
                return queue.getContent();
            case LIST:
                return orderedList.getContent();
            case BINARY:
                content = "\nInOrden:\n" +
                        binaryTree.inOrder() +
                        "\nPostOrden:\n" +
                        binaryTree.postOrder() +
                        "\nPreOrden:\n" +
                        binaryTree.preOrder();
                return content;
            case AVL:
                content = "\nInOrden:\n" +
                        avlTree.inOrder() +
                        "\nPostOrden:\n" +
                        avlTree.postOrder() +
                        "\nPreOrden:\n" +
                        avlTree.preOrder();
                return content;
            default:
                return "Estructura invalida";
        }
    }

}

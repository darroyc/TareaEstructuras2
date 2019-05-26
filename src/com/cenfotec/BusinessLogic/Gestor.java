package com.cenfotec.BusinessLogic;

import com.cenfotec.Entities.*;
import com.cenfotec.Enums.Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gestor {


    private Stack stack;
    private Queue queue;
    private OrderedList orderedList;
    private Tree tree;
    private static int value;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public Gestor(){
        stack = new Stack();
        queue = new Queue();
        orderedList = new OrderedList();
        tree = new Tree();
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
            case TREE:
                tree.push(value);
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

    private void pass(BaseStructure oldStructure, BaseStructure newStructure){
        Integer value = oldStructure.pop();
        while (value!=null){
            newStructure.push(value);
            value = oldStructure.pop();
        }
    }

    public String getStructureContent(Structure structure){
        switch (structure) {
            case STACK:
                return stack.getContent();
            case QUEUE:
                return queue.getContent();
            case LIST:
                return orderedList.getContent();
            case TREE:
                String content = "\nInOrden:\n" +
                        tree.inOrden(tree.root) +
                        "\nPostOrden:\n" +
                        tree.postOrden(tree.root) +
                        "\nPreOrden:\n" +
                        tree.preOrden(tree.root);
                return content;
            default:
                return "Estructura invalida";
        }
    }

}

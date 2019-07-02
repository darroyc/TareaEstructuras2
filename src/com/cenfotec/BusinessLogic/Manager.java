package com.cenfotec.BusinessLogic;

import com.cenfotec.Entities.Hashing.HashingAbierto;
import com.cenfotec.Entities.Hashing.HashingCerrado;
import com.cenfotec.Entities.LinearStructures.Base;
import com.cenfotec.Entities.LinearStructures.OrderedList;
import com.cenfotec.Entities.LinearStructures.Queue;
import com.cenfotec.Entities.LinearStructures.Stack;
import com.cenfotec.Entities.Trees.AVL;
import com.cenfotec.Entities.Trees.BPlusTree;
import com.cenfotec.Entities.Trees.Binary;
import com.cenfotec.Enums.Structure;

public class Manager {
    private Stack stack;
    private Queue queue;
    private OrderedList orderedList;
    private Binary binaryTree;
    private AVL avlTree;
    private HashingAbierto hashingAbierto;
    private HashingCerrado hashingCerrado;
    private BPlusTree bPlusTree;

    public Manager(){
        stack = new Stack();
        queue = new Queue();
        orderedList = new OrderedList();
        binaryTree = new Binary();
        avlTree = new AVL();
        hashingAbierto = new HashingAbierto();
        hashingCerrado = new HashingCerrado();
        bPlusTree = new BPlusTree();
    }

    public <T> void push(T value, Structure structure){
        switch (structure) {
            case STACK:
                stack.push((Comparable) value);
                break;
            case QUEUE:
                queue.push((Comparable) value);
                break;
            case LIST:
                orderedList.push((Comparable) value);
                break;
            case BINARY:
                binaryTree.insert((Integer) value);
                break;
            case AVL:
                avlTree.insert((Integer) value);
                break;
            case HASH_ABIERTO:
                hashingAbierto.add((String) value);
                break;
            case HASH_CERRADO:
                hashingCerrado.add((String) value);
                break;
        }
    }

    public <T> void insertIntoBPlusTree(T key, T value){
        bPlusTree.insert((Comparable) key, value);
    }

    public <T> Object searchInBPlusTree(T key){
        Object object = bPlusTree.search((Comparable) key);
        return object==null ? "No se pudo encontrar el valor deseado, intente de nuevo.":object;
    }

    public <T> void deleteFromBPlusTree(T key){
        bPlusTree.delete((Comparable) key);
    }

    public Object pop(Structure structure){
        Object value = 0;
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

    public <T> Object deleteFromList(T value){ return orderedList.pop((Comparable) value); }

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
        var value = oldStructure.pop();
        while (value!=null){
            newStructure.push(value);
            value = oldStructure.pop();
        }
    }

    public <T> String contains (Structure structure, T value){
        String result;
         switch (structure){
             case HASH_ABIERTO:
                 return hashingAbierto.contains((String) value);
             case HASH_CERRADO:
                 return hashingCerrado.contains((String) value);
                 default:
                     return "Estructura inválida";
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
                return "Estructura inválida";
        }
    }

}

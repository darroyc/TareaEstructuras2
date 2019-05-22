package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.company.Gestor.Structure.*;

public class Gestor {


    public static Node stack;
    public static Node queue;
    public static OrderedList orderedList = new OrderedList();
    public static int value;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void start(){
        int option = 1;
        Structure structure;

        while(option!=0){
            System.out.println("Con que desea trabajar?");
            option = printMainMenu();
            if(option!=0){
                if(option>3){
                    System.out.println("Opcion invalida digite de nuevo");
                } else {
                    structure = Structure.values()[option - 1];
                    System.out.println("Que desea hacer?");
                    option = printSecondaryMenu();
                    switch (option){
                        case 1:
                            System.out.println("Digite el elemento entero a agregar:");
                            value = readInt();
                            Node tempNode = new Node(value);
                            if (structure.equals(STACK)) {
                                addStack(tempNode);
                                //printStack();
                            } else if (structure.equals(QUEUE)) {
                                //addQueue(tempNode);
                            } else if (structure.equals(LIST)) {
                                orderedList.add(value);
                            }

                            break;
                            //printStack();
                        case 2:
                            System.out.println("Se esta eliminando un elemento");
                            if (structure.equals(STACK)) {
                            } else if (structure.equals(QUEUE)) {
                            } else if (structure.equals(LIST)) {
                                System.out.println("Digite el elemento que desea eleminar");
                                value = readInt();
                                orderedList.remove(value);
                            }
                            break;
                        case 3:
                            System.out.println("A que estrutura quiere pasar el elemento?");

                            //addStack(new Node(readInt()));
                            break;
                        case 4:
                            if (structure.equals(STACK)) {
                                printStructure(stack);
                            } else if (structure.equals(QUEUE)) {
                                printStructure(queue);
                            } else if (structure.equals(LIST)) {
                                System.out.println(orderedList.getContent());
                            }
                            break;
                    }

                }
            }
        }
    }

    private int printMainMenu(){
        System.out.println("1. Lista");
        System.out.println("2. Cola");
        System.out.println("3. Fila");
        System.out.println("0. Salir");
        return readInt();
    }


    private int printSecondaryMenu(){
        System.out.println("1. Agregar");
        System.out.println("2. Eliminar");
        System.out.println("3. Pasar");
        System.out.println("4. Mostrar");
        return readInt();
    }

    private void addStack(Node v_node){
        if(stack == null){
            stack = new Node();
            stack = v_node;
        } else {
            Node tempNode = stack;
            stack = v_node;
            stack.setNextNode(tempNode);
        }
    }

    private void printStack(){
        Node tempNode = stack;
        while (tempNode != null){
            System.out.println("[" +tempNode.getValue()+"],");
            tempNode =  tempNode.getNextNode();
        }
    }

    private void printStructure(Node v_node){
        while (v_node != null){
            System.out.println("[" +v_node.getValue()+"],");
            v_node =  v_node.getNextNode();
        }
    }

    private void addQueue(Node v_node){
        if(queue == null){
            queue = new Node();
            queue = v_node;
        } else {
            Node tempNode = stack;
            while (tempNode != null){
                tempNode = tempNode.getNextNode();
            }
           tempNode.setNextNode(v_node);
        }
    }

    private void addList(Node v_node){
    //TODO CREAR EL ADD LIST METHOD
    }
    
    private int readInt(){
        try {
            return Integer.parseInt(in.readLine());
        }catch (Exception e){
            System.out.println("Digite un numero para agregar");
            return readInt();
        }
    }

    public enum Structure {
        LIST,
        QUEUE,
        STACK;
    }

    public enum Action {
        ADD,
        DELETE,
        CONVERT;
    }

}

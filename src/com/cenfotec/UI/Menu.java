package com.cenfotec.UI;


import com.cenfotec.Enums.Structure;
import com.cenfotec.BusinessLogic.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.cenfotec.Enums.Structure.*;

public class Menu {
    private Manager manager;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private Structure structure;

    public void start() {
        int option = 1;
        manager = new Manager();
        while (option != 0) {
            print("Con que desea trabajar?");
            option = printMainMenu();
            if(option!=0){
                structure = Structure.values()[option - 1];
                if(option>=4){
                    while (option!=3){
                        print("\nQue desea hacer?");
                        option = treeStructuresMenu();
                    }
                }else {
                    while (option!=5){
                        print("\nQue desea hacer?");
                        option = linearStructuresMenu();
                    }
                }
            }
        }
    }

    private int printMainMenu() {
        print("1. Lista");
        print("2. Fila");
        print("3. Pila");
        print("4. Árbol Binario");
        print("5. Árbol AVL");
        print("0. Salir");
        return getOption(5, 0);
    }

    private int printPassMenu() {
        print("1. Lista");
        print("2. Fila");
        print("3. Pila");
        print("0. Salir");
        return getOption(3, 0);
    }

    private int linearStructuresMenu() {
        Object value;
        print("1. Agregar");
        print("2. Eliminar");
        print("3. Pasar");
        print("4. Mostrar");
        print("5. Ir al selector de estructuras");
        int option = getOption(5, 1);
        switch (option) {
            case 1:
                print("\nDigite el elemento entero a agregar:");
                value = read();
                manager.push(value, structure);
                break;
            case 2:
                Object deletedValue;
                if (structure == LIST) {
                    print("\nDigite el elemento que desea eliminar");
                    var valueToDelete = read();
                    deletedValue = manager.deleteFromList(valueToDelete);
                }else{
                    deletedValue = manager.pop(structure);
                }
                if (deletedValue != null) {
                    print("\nEl número " + deletedValue + " fue eliminado de la estructura.");
                } else {
                    print("\nLa " + translateStructureName(structure) + " esta vacia o no cuenta con el numero seleccionado");
                }
                break;
            case 3:
                print("\nA que estructura quiere pasar el elemento?");
                option = printPassMenu();
                if (option != 0) {
                    Structure newStructure = Structure.values()[option - 1];
                    if(newStructure != structure){
                        print("De " + translateStructureName(structure) + " a " + translateStructureName(newStructure));
                        structure = manager.convert(newStructure, structure);
                    }else {
                        print("Se seleccionó el mismo tipo de estructura.");
                    }
                }
                break;
            case 4:
                print(manager.getStructureContent(structure));
                break;
            case 5:
                    break;
        }
        return option;
    }

    private int treeStructuresMenu() {
        print("1. Agregar");
        print("2. Mostrar");
        print("3. Ir al selector de estructuras");
        int option = getOption(3, 1);
        switch (option) {
            case 1:
                print("\nDigite el elemento entero a agregar:");
                int value = readInt();
                manager.push(value, structure);
                break;
            case 2:
                print(manager.getStructureContent(structure));
                break;
            case 5:
                break;
        }

        return option;
    }

    private int readInt() {
        try {
            return Integer.parseInt(in.readLine());
        } catch (IOException e) {
            print("Digite un numero para agregar");
            return readInt();
        }
    }

    private Object read() {
        try {
            return in.readLine();
        } catch (IOException e) {
            print("Lo que ingreso no puede ser reconocido. Intente de nuevo");
            return readInt();
        }
    }

    private int getOption(int max, int min) {
        int option;
        while (true) {
            option = readInt();
            if (option > max || option < min) {
                print("Opcion invalida digite de nuevo");
            } else {
                return option;
            }
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String translateStructureName(Structure structure) {
        switch (structure) {
            case STACK:
                return "pila";
            case QUEUE:
                return "fila";
            case LIST:
                return "lista ordenada";
            case BINARY:
                return "árbol binario";
            case AVL:
                return "árbol AVL";
            default:
                return "Estructura invalida";
        }
    }

}

package com.cenfotec.UI;


import com.cenfotec.Enums.Structure;
import com.cenfotec.BusinessLogic.Gestor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.cenfotec.Enums.Structure.*;

public class Menu {
    private Gestor gestor;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private Structure structure;

    public void start() {
        int option = 1;
        gestor = new Gestor();
        while (option != 0) {
            print("Con que desea trabajar?");
            option = printMainMenu();
            if(option!=0){
                structure = Structure.values()[option - 1];
                if(option==4){
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
        print("4. Árbol");
        print("0. Salir");
        return getOption(4, 0);
    }

    private int printPassMenu() {
        print("1. Lista");
        print("2. Fila");
        print("3. Pila");
        print("0. Salir");
        return getOption(3, 0);
    }

    private int linearStructuresMenu() {
        int value;
        print("1. Agregar");
        print("2. Eliminar");
        print("3. Pasar");
        print("4. Mostrar");
        print("5. Ir al selector de estructuras");
        int option = getOption(5, 1);
        switch (option) {
            case 1:
                print("\nDigite el elemento entero a agregar:");
                value = readInt();
                gestor.push(value, structure);
                break;
            case 2:
                Integer deletedValue = null;
                if (structure == LIST) {
                    print("\nDigite el elemento que desea eliminar");
                    int valueToDelete = readInt();
                    deletedValue = gestor.deleteFromList(valueToDelete);
                }
                deletedValue = gestor.pop(structure);
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
                        structure = gestor.convert(newStructure, structure);
                    }else {
                        print("Se seleccionó el mismo tipo de estructura.");
                    }
                }
                break;
            case 4:
                print(gestor.getStructureContent(structure));
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
                gestor.push(value, structure);
                break;
            case 2:
                print(gestor.getStructureContent(structure));
                break;
            case 5:
                break;
        }

        return option;
    }

    private int readInt() {
        try {
            return Integer.parseInt(in.readLine());
        } catch (Exception e) {
            print("Digite un numero para agregar");
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
            case TREE:
                return "árbol";
            default:
                return "Estructura invalida";
        }
    }

}

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
            print("¿Con qué desea trabajar?");
            option = printMainMenu();
            if(option!=0){
                structure = Structure.values()[option - 1];

                if(option >=4){

                    if(option >= 6){

                        while (option!=4){
                            print("\n¿Qué desea hacer?");
                            option = hashingMenu();
                        }

                    }else{
                        while (option!=3){
                            print("\n¿Qué desea hacer?");
                            option = treeStructuresMenu();
                        }
                    }

                }
                else {
                    while (option!=5){
                        print("\n¿Qué desea hacer?");
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
        print("6. Hashing Abierto");
        print("7. Hashing Cerrado");
        print("0. Salir");
        return getOption(7, 0);
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
                    print("\nLa " + translateStructureName(structure) + " está vacía o no cuenta con el número seleccionado");
                }
                break;
            case 3:
                print("\n¿A qué estructura quiere pasar el elemento?");
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
        print("2. Buscar");
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

    private int hashingMenu() {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        print("1. Agregar elementos predeterminados por cédula");
        print("2. Agregar elementos predeterminados por apellido");
        print("3. Buscar");
        print("4. Ir al selector de estructuras");
        int option = getOption(4, 1);
        switch (option) {
            case 1:
                manager.push("cedula", structure);
                break;
            case 2:
                manager.push("apellido", structure);

                break;
            case 3:
                print("Ingrese un valor");
                var value = read();

                print(manager.contains(structure, value));
                break;
            case 4:
                break;
            default:
                print("Ingrese una opción válida");
                break;
        }

        return option;
    }

    private int readInt() {
        try {
            return Integer.parseInt(in.readLine());
        } catch (IOException e) {
            print("Digite un número para agregar");
            return readInt();
        }
    }

    private Object read() {
        try {
            return in.readLine();
        } catch (IOException e) {
            print("Lo que ingreso no pude ser reconocido. Intente de nuevo");
            return readInt();
        }
    }

    private int getOption(int max, int min) {
        int option;
        while (true) {
            option = readInt();
            if (option > max || option < min) {
                print("Opción inválida digite de nuevo");
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
            case HASH_ABIERTO:
                return "hashing abierto";
            case HASH_CERRADO:
                return "hashing cerrado";
            default:
                return "Estructura inválida";
        }
    }

}

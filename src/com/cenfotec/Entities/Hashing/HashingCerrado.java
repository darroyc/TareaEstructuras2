package com.cenfotec.Entities.Hashing;

import com.cenfotec.Entities.General.Persona;
import com.cenfotec.Entities.Hashing.Node.NodoHash;

import java.util.Arrays;

public class HashingCerrado {

    private static int SIZE = 10;

    private static NodoHash[] hashtable = new NodoHash[SIZE];
    private static Persona[] personas = new Persona[7];

    public void add (String tipo){
        Arrays.fill(personas, null);

        personas[0] = new Persona("1", "silvia", "bolanos");
        personas[1] = new Persona("2", "daniel", "arroyo");
        personas[2] = new Persona("3", "izahir", "cascante");
        personas[3] = new Persona("4", "maria", "prada");
        personas[4] = new Persona("5", "luis", "contreras");
        personas[5] = new Persona("6", "eugenia", "bolanos");
        personas[6] = new Persona("7", "gloriana", "trejos");

        int i = 0;
        while(i < personas.length){
            add(personas[i], tipo);
            i++;
        }
    }

    public void add(Persona value, String tipo) {

        if (tipo.equals("cedula")){
            tipo = value.getCedula();
        }else{
            tipo = value.getApellido();
        }

        int hash = getIndex(tipo);

        for (int x = 0; x < SIZE; x++){
            if (hashtable[hash] == null) {
                hashtable[hash] = new NodoHash(tipo, value);
                break;
            }else{
                hash++;

                if (hash == SIZE){
                    hash = 0;
                }
            }
        }
    }

    public String contains(String value) {
        value = value.toLowerCase();
        int hash = getIndex(value);
        String list = "";

        for (int x = 0; x < SIZE; x++){

            if (hashtable[hash] != null && hashtable[hash].getKey().equals(value)) {
                list = list + hashtable[hash].getNodoLista().toString() + "\n";
            }
                hash++;

            if (hash == SIZE){
                hash = 0;
            }

        }

        if(!list.equals("")){
            return list;
        }else{
            return "No se ha encontrado";
        }
    }


    public int getIndex (String s){

        int hashValue = s.hashCode();
        hashValue = hashValue & 0x7fffffff;
        hashValue = hashValue % SIZE;
        return hashValue;
    }
}
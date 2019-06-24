package com.cenfotec.Entities.Hashing.Node;

import com.cenfotec.Entities.General.Persona;

public class NodoHash {
    private String key;
    private NodoHash nodoHash;
    private Persona nodoLista;

    public NodoHash(){
        setKey(null);
        setNodoHash(null);
        setNodoLista(null);
    }

    public NodoHash(String key, Persona persona){
        setKey(key);
        setNodoHash(null);
        setNodoLista(persona);

    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public NodoHash getNodoHash() {
        return nodoHash;
    }

    public void setNodoHash(NodoHash nodoHash) {
        this.nodoHash = nodoHash;
    }

    public Persona getNodoLista() {
        return nodoLista;
    }

    public void setNodoLista(Persona nodoLista) {
        this.nodoLista = nodoLista;
    }
}

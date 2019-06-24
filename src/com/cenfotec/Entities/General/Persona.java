package com.cenfotec.Entities.General;

public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(){}

    public Persona(String cedula, String nombre, String apellido){
        setCedula(cedula);
        setNombre(nombre);
        setApellido(apellido);
    }

    @Override
    public String toString(){
        return "Cédula: " + getCedula() + ". Nombre: " + getNombre() + ". Apellido: " + getApellido();
    }
}

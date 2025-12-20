package com.example.demo.model;


public class Persona implements  IObtenerID{
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getID() {
        return String.format("%s-%s", this.nombre, this.apellido);
    }
}

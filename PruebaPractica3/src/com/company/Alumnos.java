package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alumnos {

    //atributos
    private int Id;
    private int carne;
    private String nombre;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate fecha;
    private char genero;

    public Alumnos(int id, int carne, String nombre, LocalDate fecha, char genero) {
        Id = id;
        this.carne = carne;
        this.nombre = nombre;
        this.fecha = fecha;
        this.genero = genero;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}

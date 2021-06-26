package com.company;

public class Cursos {
    private int Id;
    private int codigo;
    private String nombre;
    private Notas AluNotas [] = new Notas[1];


    public Cursos(int id, int codigo, String nombre) {
        Id = id;
        this.codigo = codigo;
        this.nombre = nombre;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Notas[] getAluNotas() {
        return AluNotas;
    }

    public void setAluNotas(Notas[] aluNotas) {
        AluNotas = aluNotas;
    }


}

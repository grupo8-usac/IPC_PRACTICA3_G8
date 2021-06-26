package com.company;

public class Notas {
    private Alumnos alumno;
    private double nota = 0;
    private boolean Asignacion = false;

    public Notas(Alumnos alumno) {
        this.alumno = alumno;
    }

    public boolean isAsignacion() {
        return Asignacion;
    }

    public void setAsignacion(boolean asignacion) {
        Asignacion = asignacion;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
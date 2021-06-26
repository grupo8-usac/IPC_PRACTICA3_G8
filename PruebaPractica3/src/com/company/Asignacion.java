package com.company;

import java.time.LocalDate;

public class Asignacion {
    //atributos
    Alumnos alumno;
    Cursos curso;

    public Asignacion(Alumnos alumno, Cursos curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

}
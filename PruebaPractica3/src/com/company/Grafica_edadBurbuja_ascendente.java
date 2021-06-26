package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Grafica_edadBurbuja_ascendente extends Thread {
    JLabel muestra;
    JPanel grafica;
    double tiempos;
    DefaultCategoryDataset datos_barras;
    boolean terminar;
    int contadorgeneral;

    public Grafica_edadBurbuja_ascendente(JPanel grafica,int tiempos){
        this.grafica=grafica;
        this.tiempos=tiempos;
    }
    static Notas[] orden(Notas[] Burbuja){

        Notas Actual;
        int dim = 0;
        for (int i = 0; i < Burbuja.length; i++) {
            if(Burbuja[i] != null){
                if(Burbuja[i].getAlumno() != null){
                    dim++;
                }
            }
        }

        Notas Burbuja1 [] = new Notas[dim];
        for (int i = 0; i < Burbuja1.length; i++) {
            if(Burbuja[i]!=null && Burbuja[i].getAlumno() != null){
                Burbuja1[i] = Burbuja[i];
            }
        }

        for (int i = Burbuja1.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Burbuja1[j].getNota() > Burbuja1[j + 1].getNota()) {
                    Actual = Burbuja1[j];
                    //Reasignacion
                    Burbuja1[j] = Burbuja1[j + 1];
                    Burbuja1[j + 1] = Actual;
                }
            }
        }
        return Burbuja1;//retornamos la nueva lista ya ordenada.
    }


    public void run(){
        if (ventana.Cursos != null) {
            terminar = true;
            for (int i = 0; i < ventana.Cursos.length; i++) {
                if (ventana.Cursos[i] != null) {
                    if (ventana.Cursos[i].getId() == ventana2.id_curso) {
                        // int alum = 0;
                        Notas temp[] = ventana.Cursos[i].getAluNotas(); //ventana.Cursos[i].getAluNotas();
                        try {
                            int contador=0;
                            datos_barras = new DefaultCategoryDataset();// default
                            for (int j = 0; j < temp.length; j++) {
                                if (temp[j] != null) {
                                    System.out.println(temp[j].getNota());
                                    System.out.println("El alumno es: "+temp[j].getAlumno().getNombre()+" Y su id es :"+ temp[j].getAlumno().getId());
                                    System.out.println("Su nota es: "+temp[j].getNota() );
                                    temp[j].getNota();
                                    contador++;
                                    datos_barras.setValue(temp[j].getNota(), ""+temp[j].getAlumno().getId(), ""+temp[j].getNota()+""+contador);
                                }
                                JFreeChart grafico_barras = ChartFactory.createBarChart(
                                        "Notas del Curso",    ///nommbre del curso
                                        "Id_Alumnos",   /// nombre eje x
                                        "Notas",   /// nombre eje y
                                        datos_barras,             // datos o cantidades a ingresar
                                        PlotOrientation.VERTICAL,/// horizontal PlotOrientation.HORIZONTAL  o verticcal  PlotOrientation.VERTICAL
                                        true,//legenda el dato de abajo >=v de los colores graficados
                                        true,
                                        false);
                                java.awt.image.BufferedImage image = grafico_barras.createBufferedImage(600, 500);
                                muestra = new JLabel(new ImageIcon(image));
                                muestra.setBounds(20, 90, 800, 500);
                                grafica.removeAll();//REMOVER LO DEL PANEL

                                grafica.add(muestra);//añadir
                                grafica.repaint();//repintar
                            }

                        } catch (Exception e) {
                            System.out.println("Lista de alumnos del curso terminada");
                        }

                    }

                }

            }
        }
        if (ventana.Cursos != null) {
            for (int i = 0; i < ventana.Cursos.length; i++) {
                if (ventana.Cursos[i] != null) {
                    if (ventana.Cursos[i].getId() == ventana2.id_curso) {
                        // int alum = 0;
                        Notas temp1[] = orden(ventana.Cursos[i].getAluNotas()); //ventana.Cursos[i].getAluNotas();
                        try {
                            int contador=0;
                            datos_barras = new DefaultCategoryDataset();// default
                            for (int j = 0; j < temp1.length; j++) {
                                if (temp1[j] != null) {
                                    sleep( (int) tiempos* 200) ;
                                    ///double tiempo= 1.5;
                                    contador++;
                                    datos_barras.setValue(temp1[j].getNota(), ""+temp1[j].getAlumno().getId(), ""+temp1[j].getNota()+""+contador);
                                }
                                contadorgeneral++;
                                JFreeChart grafico_barras = ChartFactory.createBarChart(
                                        "Notas del Curso",    ///nommbre del curso
                                        "Id_Alumnos",   /// nombre eje x
                                        "Notas",   /// nombre eje y
                                        datos_barras,             // datos o cantidades a ingresar
                                        PlotOrientation.VERTICAL,/// horizontal PlotOrientation.HORIZONTAL  o verticcal  PlotOrientation.VERTICAL
                                        true,//legenda el dato de abajo >=v de los colores graficados
                                        true,
                                        false);
                                java.awt.image.BufferedImage image = grafico_barras.createBufferedImage(600, 500);
                                muestra = new JLabel(new ImageIcon(image));
                                muestra.setBounds(10, 110, 800, 500);
                                grafica.removeAll();//REMOVER LO DEL PANEL
                                Grafica_ordenada.tiempo.setText("Tiempo "+ tiempo.minutos + " : " + tiempo.segundos);//agregando el tiempo al Jlabel
                                Grafica_ordenada.pasos.setText("Pasos : "+contadorgeneral+1);
                                grafica.add(Grafica_ordenada.pasos);
                                grafica.add(Grafica_ordenada.orden);
                                grafica.add(Grafica_ordenada.tipo);
                                grafica.add(Grafica_ordenada.velocidad);
                                grafica.add(Grafica_ordenada.tiempo);
                                grafica.add(Grafica_ordenada.b3);
                                grafica.add(muestra);//añadir
                                grafica.repaint();//repintar
                            }
                        } catch (Exception e) {
                            System.out.println("Lista de alumnos del curso terminada");
                        }
                    }
                }
            }
        }
        terminar=false;
        while(terminar==false){
            tiempo tiempo1=new tiempo();
            tiempo1.stop();
            //  Thread.tiempo.stop();

        }

    }


}


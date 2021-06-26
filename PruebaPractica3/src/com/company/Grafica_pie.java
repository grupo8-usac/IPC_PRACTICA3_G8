package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

import static com.company.ventana2.guardar;

public class Grafica_pie extends Thread {
    double H, M = 0;
    int contadorgenero = 0;
    JLabel muestra;
    JPanel grafica;

    public Grafica_pie(JPanel grafica) {
        this.grafica = grafica;
    }


    public void run() {
        try {
            if (ventana.Cursos != null){
                for (int i = 0; i < ventana.Cursos.length; i++) {
                    if (ventana.Cursos[i] != null) {
                        if (ventana.Cursos[i].getId()==ventana2.id_curso) {
                            int alum = 0;
                            Notas temp[] = ventana.Cursos[i].getAluNotas();
                            for (int j = 0; j < temp.length; j++) {
                                //if (temp[j] != null) {
                                //if (temp[j].getAlumno() != null) {
                                sleep(500);
                                alum++;
                                try {
                                    if (String.valueOf(temp[j].getAlumno().getGenero()).equals("F")) {
                                        System.out.println(temp[j].getAlumno().getGenero());
                                        System.out.println(temp[j].getAlumno().getNombre());
                                        System.out.println(temp[j].getNota());

                                        M++;
                                        System.out.println("aumentaron Mujer");
                                        contadorgenero++;
                                    } else if (String.valueOf(temp[j].getAlumno().getGenero()).equals("M")) {
                                        H++;
                                        System.out.println(temp[j].getAlumno().getGenero());
                                        System.out.println(temp[j].getAlumno().getNombre());
                                        System.out.println(temp[i].getNota());
                                        System.out.println("aumentaron Hombre");
                                        contadorgenero++;
                                    } else {
                                        System.out.println("nel prro");
                                    }
                                    double hH = (H / contadorgenero) * 100;
                                    double mM = (M / contadorgenero) * 100;
                                    DefaultPieDataset datosGrafica = new DefaultPieDataset();
                                    double redondeoH = Math.round(H * 100);
                                    redondeoH = redondeoH / 100;
                                    double redondeoM = Math.round(M * 100);
                                    redondeoM = redondeoM / 100;
                                    datosGrafica.setValue("MUJERES " + Math.round(hH * 0.01 * contadorgenero), redondeoM);
                                    datosGrafica.setValue("HOMBRES " + Math.round(mM * 0.01 * contadorgenero), redondeoH);
                                    JFreeChart grafico = ChartFactory.createPieChart("Género de Alumnos en el Curso", datosGrafica, true, true, false);
                                    java.awt.image.BufferedImage image = grafico.createBufferedImage(450, 290);
                                    muestra = new JLabel(new ImageIcon(image));
                                    muestra.setBounds(50, 25, 400, 400);
                                    grafica.removeAll();
                                    grafica.add(muestra);
                                    grafica.add(VentanaPie.etiqueta);
                                    grafica.add(VentanaPie.regresar);
                                    grafica.repaint();
                                    //} else {
                                    //  System.out.println("no hay nadaaaa");
                                    //}
                                    //} else {
                                    //  System.out.println("No entra aquí ----");
                                    //}
                                } catch (Exception e) {
                                    System.out.println("Lista de alumnos del curso terminada");
                                }

                            }
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.time.LocalDate;

public class Grafica_barras extends Thread {
    int intervalo_10, intervalo_20, intervalo_30, intervalo_40, intervalo_50, intervalo_60, intervalo_70, intervalo_80, intervalo_90, intervalo_100 = 0;
    JLabel muestra;
    JPanel grafica;

    public Grafica_barras(JPanel grafica) {
        this.grafica = grafica;
    }

    public void run() {
        try {
            if (ventana.Cursos != null) {
                for (int i = 0; i < ventana.Cursos.length; i++) {
                    if (ventana.Cursos[i] != null) {
                        if (ventana.Cursos[i].getId() == ventana2.id_curso) {
                        int alum = 0;
                        Notas temp[] = ventana.Cursos[i].getAluNotas();
                        try {

                            for (int j = 0; j < temp.length; j++) {
                                LocalDate edad = temp[j].getAlumno().getFecha();
                                int nuevaedad = 2021 - edad.getYear() ;
                                if (temp[j] != null) {
                                    //for (int i = 0; i < alumnos.length; i++) {
                                    sleep(500);
                                    //   System.out.println(alumnos[i].getId_alumno());
                                    System.out.println(nuevaedad);
                                    if (temp[i] != null) {
                                        if (nuevaedad > 0 && nuevaedad <= 11) {
                                            intervalo_10++;
                                        } else if (nuevaedad > 9 && nuevaedad <= 21) {
                                            intervalo_20++;
                                        } else if (nuevaedad > 19 && nuevaedad <= 31) {
                                            intervalo_30++;
                                        } else if (nuevaedad > 29 && nuevaedad <= 41) {
                                            intervalo_40++;
                                        } else if (nuevaedad > 39 && nuevaedad <= 51) {
                                            intervalo_50++;
                                        } else if (nuevaedad > 49 && nuevaedad <= 61) {
                                            intervalo_60++;
                                        } else if (nuevaedad > 59 && nuevaedad <= 71) {
                                            intervalo_70++;
                                        } else if (nuevaedad > 69 && nuevaedad <= 81) {
                                            intervalo_80++;
                                        } else if (nuevaedad > 79 && nuevaedad <= 91) {
                                            intervalo_90++;
                                        } else if (nuevaedad > 89 && nuevaedad <= 101) {
                                            intervalo_100++;
                                        }
                                        DefaultCategoryDataset datos_barras = new DefaultCategoryDataset();// default
                                        datos_barras.setValue(intervalo_10, "[0-10]", "[0-10]");
                                        datos_barras.setValue(intervalo_20, "[10-20]", "[10-20]");
                                        datos_barras.setValue(intervalo_30, "[20-30]", "[20-30]");
                                        datos_barras.setValue(intervalo_40, "[30-40]", "[30-40]");
                                        datos_barras.setValue(intervalo_50, "[40-50]", "[40-50]");
                                        datos_barras.setValue(intervalo_60, "[50-60]", "[50-60]");
                                        datos_barras.setValue(intervalo_70, "[60-70]", "[60-70]");
                                        datos_barras.setValue(intervalo_80, "[70-80]", "[70-80]");
                                        datos_barras.setValue(intervalo_90, "[80-90]", "[80-90]");
                                        datos_barras.setValue(intervalo_100, "[90-100]", "[90-100]");
                                        //datos_barras es para añadir los datos que queremos
                                        // //datos_barras.setvalue("Cantidad",nombre eje x,nombre eje y )
                                        //creamos la grafica con JFreechart  de barras
                                        JFreeChart grafico_barras = ChartFactory.createBarChart(
                                                "Edad de los Alumnos en el Curso",    ///nommbre del curso
                                                "Edades",   /// nombre eje x
                                                "Cantidad",   /// nombre eje y
                                                datos_barras,             // datos o cantidades a ingresar
                                                PlotOrientation.HORIZONTAL,/// horizontal PlotOrientation.HORIZONTAL  o verticcal  PlotOrientation.VERTICAL
                                                true,//legenda el dato de abajo >=v de los colores graficados
                                                true,
                                                false);

                                        java.awt.image.BufferedImage image = grafico_barras.createBufferedImage(600, 500);
                                        muestra = new JLabel(new ImageIcon(image));
                                        muestra.setBounds(10, 40, 800, 500);
                                        grafica.removeAll();//REMOVER LO DEL PANEL
                                        grafica.add(muestra);//añadir
                                        grafica.add(ventanaBarr.etiqueta);
                                        grafica.add(ventanaBarr.regresar);
                                        grafica.repaint();//repintar
                                    }
                                    //  System.out.println("es:" + intervalo_10);
                                    //}
                                }

                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    }
                }
            }

        } catch (Exception e) {
        }
    }

}

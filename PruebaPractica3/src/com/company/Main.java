package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Alumnos Alumnos[] = new Alumnos[100];
    static Alumnos contenidoAlu;
    public String Ruta;
    static int contador_alumnos = 0;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static void main(String[] args) {
        //String contenidoAlu = files.getContentOfFile(R1+"jsons\\users.json"); //---------
        ventana v1 = new ventana();
        v1.setVisible(true);
       // v1.asd();
        //Main inicio = new Main();
        //inicio.CargaAlumnos();
    }

    public void Ruta() {
        Scanner leer = new Scanner(System.in);//Instanciando scanner
        System.out.println(">>>Ingrese la ruta del archivo que desea leer: ");
        System.out.print(">");
        String R1 = leer.nextLine();
        Ruta = R1;


    }
     /*String contenidoalu = files.getContentOfFile(Ruta + "\\Alumnos.csv");
        System.out.println(contenidoalu);*/

        /*int dim = files.obtenerDimension(contenidoalu);
        dim = dim - 1;

        System.out.println("Cantidad de lineas" + dim);*/


    void CargaAlumnos() {
        try {
            Scanner leer = new Scanner(System.in);
            System.out.println("\n------Carga Alumnos------");
            //En caso que se desee realizar otra carga puede realizarce.

            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            try {
                System.out.println("Ingrese la ruta del archivo CSV con los datos de los alumnos");
                System.out.print(">");
                String R1 = leer.nextLine();
                R1 = R1.replaceAll("\"", "");
                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;

                try {
                    // Apertura del fichero y creacion de BufferedReader para poder
                    // hacer una lectura comoda (disponer del metodo readLine()).
                    archivo = new File(R1);
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);

                    // Lectura del fichero
                    String linea;
                    int contador = 0;
                    boolean contLectura = true;
                    while ((linea = br.readLine()) != null && contLectura) {
                        boolean correcto = true;
                        if (contador != 0 && correcto) {
                            String contenido[] = linea.split(",");

                            int id;
                            int carne;
                            String nombre;
                            LocalDate fechaNacimiento;
                            char genero;
                            try {
                                id = Integer.parseInt(contenido[0].trim());
                                if (correcto) {
                                    try {
                                        carne = Integer.parseInt(contenido[1].trim());
                                        if (correcto) {
                                            try {
                                                nombre = contenido[2].trim();
                                                if (correcto) {
                                                    try {
                                                        String textoFecha = contenido[3].trim();
                                                        fechaNacimiento = LocalDate.parse(textoFecha, fmt);
                                                        if (correcto) {
                                                            try {
                                                                genero = contenido[4].trim().charAt(0);
                                                                genero = Character.toUpperCase(genero);

                                                                if (genero == 'M' || genero == 'F') {
                                                                    try {
                                                                        int aux = 0;
                                                                        if (Alumnos[99] == null) {
                                                                            if (!IdRepetido(id)) {
                                                                                while (correcto && aux < 100) {
                                                                                    if (Alumnos[aux] == null) {
                                                                                        Alumnos[aux] = new Alumnos(id, carne, nombre, fechaNacimiento, genero);
                                                                                        correcto = false;
                                                                                    } else {
                                                                                        aux++;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nerror en la linea " + (contador + 1));
                                                                                correcto = false;
                                                                            }
                                                                        } else {
                                                                            System.out.println("\nerror en la linea " + (contador + 1));
                                                                            correcto = false;
                                                                            contLectura = false;

                                                                        }
                                                                    } catch (Exception e) {
                                                                        System.out.println("\nerror en la linea " + (contador + 1));
                                                                        correcto = false;
                                                                    }
                                                                } else {
                                                                    System.out.println("\nerror en la linea " + (contador + 1));
                                                                    correcto = false;
                                                                }
                                                            } catch (Exception e) {
                                                                System.out.println("\nerror en la linea " + (contador + 1));
                                                                correcto = false;
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        System.out.println("\nerror en la linea " + (contador + 1));
                                                        correcto = false;
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("\nerror en la linea " + (contador + 1));
                                                correcto = false;
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("\nerror en la linea " + (contador + 1));
                                        correcto = false;
                                    }
                                }

                            } catch (Exception e) {
                                System.out.println("\nerror en la linea " + (contador + 1));
                            }


                        }
                        contador++;
                    }

                    System.out.println("\nCarga terminada.\n");
                    File f = new File("log.log"); // Creamos un objeto file
                    System.out.println("\nPuede ver los errores en : "+f.getAbsolutePath()+"\n");


                } catch (IOException e) {
                    System.out.println("error");


                } finally {
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (IOException e2) {
                        System.out.println("error");
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error.//" + "--");
            }


            //<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        } catch (Exception e) {
            System.out.println("Ocurrio un error con la ruta del archivo CSV que proporcionaste\nIntenta nuevamente.");
        }


    }


    public void CargaCursos() {
        String contenidoCurso = files.getContentOfFile(Ruta + "\\Cursos.csv");
        System.out.println(contenidoCurso);
    }

    public void CargaNotas() {
        String contenidoNota = files.getContentOfFile("Archivos\\Notas.csv");
    }

    public boolean IdRepetido(int id) {
        for (int i = 0; i < Alumnos.length; i++) {
            if (Alumnos[i] != null) {
                if (Alumnos[i].getId() == id) {
                    return true;
                }
            }
        }
        return false;

    }
}

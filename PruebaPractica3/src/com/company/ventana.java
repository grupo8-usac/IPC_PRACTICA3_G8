package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;



public class ventana extends JFrame implements ActionListener {

    static String ruta;
    static int contador_alumnos, contador_cursos = 0;
    static Alumnos Alumnos[] = new Alumnos[300];
    static Cursos Cursos[] = new Cursos[300];
    public static Asignacion Asignacion[] = new Asignacion[300];
    public static int contAsignacionAlumnos = 0;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    int contealu;



    public JPanel panel;//declarar panel
    private JTextField cajatexto1;
    private JButton boton, boton1;
    private JLabel etiqueta;
    private  Image imagen1;


    public ventana() {
        FondoPanel fondo = new FondoPanel();
        ////agregando esa imagen
        this.add(fondo);
        this.setContentPane(fondo);
        /////////pinche panel////////////
        panel = new JPanel(); //instanciando panel
        panel.setLayout(null);// desactivando el diseño
        panel.setBackground(Color.lightGray);
        this.getContentPane().add(panel); //agrega panel a ventana



        ///////////Agregando botones/////////////////////
        boton = new JButton("CARGAR");
        boton.setBorder(BorderFactory.createLineBorder(Color.green));
        boton.setBounds(70, 170, 140, 40);
        boton.setBackground(Color.black);//color del fondo del boton
        boton.setForeground(Color.white);//colo de la letra del texto
        boton.setFont(new Font("cooper black",0,12));
        boton.setVisible(true);//
        boton.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add( boton);
        ////////////////////////
        boton1 = new JButton("ENTRAR");
        boton1.setBorder(BorderFactory.createLineBorder(Color.yellow));
        boton1.setBounds(270, 170, 150, 40);
        boton1.setBackground(Color.black);//color del fondo del boton
        boton1.setForeground(Color.white);//colo de la letra del texto
        boton1.setFont(new Font("cooper black",0,12));
        boton1.setVisible(true);//
        boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(     boton1);
        ////////////////////

        //////////////////////ETIQUETA////////////////////////////////
        etiqueta = new JLabel("INGRESE LA RUTA DE LA CARGA");// instanciamos una Jlabel con el nombre de etiqueta
        etiqueta.setBounds(150,5,300,30);
        etiqueta.setForeground(Color.red);//colo de la letra del texto
        etiqueta.setFont(new Font("cooper black",0,12));
        etiqueta.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(     etiqueta);


        ///////////////////////////caja de texto /////////////////////
        cajatexto1 = new JTextField();// instanciamos la caja de texto
        cajatexto1.setBackground(Color.lightGray);//color de caja de texto
        cajatexto1.setForeground(Color.black);//color de letra de caja de texto
        cajatexto1.setBounds(25, 50, 400, 30);//establece posicion de caja de texto
        cajatexto1.setVisible(true);

        this.add(cajatexto1);


        /////////////////////Elementos_ventana/////////////////////
        this.setTitle("*Practica 3*");
        this.setBounds(500, 150, 500, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            ruta = cajatexto1.getText();
            if (ruta.equals("")) {
                System.out.println("El campo 1 esta vacío");
                JOptionPane.showMessageDialog(null, "No se ingresaron datos" + cajatexto1.getText());
            } else {
                System.out.println("El campo 1 esta lleno");
                JOptionPane.showMessageDialog(null, "se ha cargado los datos correctamente");
                CargaAlumnos();
                CargaCursos();
                Asignacion();
                AsigNotas();
            }
        }


        if (e.getSource() == boton1) {
            System.out.println("Presionaste el boton entrar");
            ventana2 v2 = new ventana2();
            v2.setVisible(true);
            this.dispose();



        }
    }

    class FondoPanel extends JPanel{



        @Override
        public void paint(Graphics g) {

            imagen1= new ImageIcon(getClass().getResource("/imagen/fondo2.gif")).getImage();
            g.drawImage(imagen1, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);

        }
    }

//    public void asd() {
//        ActionListener boton1 = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                ruta = cajatexto1.getText();//aqui guardamos en la variable lo que se introduce en la caja de texto
//                CargaAlumnos();
//                CargaCursos();
//                Asignacion();
//                AsigNotas();
//                mostrar();
//              // esto es para crear otra ventana al cargar , esta como prueba de la grafica de barras queestabab haceindo
//
//                    ventana2 v2 = new ventana2();
//
//                    v2.setVisible(true);
//
//
//
//
//            }
//
//        };
//        boton.addActionListener(boton1);
//
//    }

    void CargaAlumnos() {
        try {
            Scanner leer = new Scanner(System.in);
            try {

                String R1 = ruta + "\\Alumnos.csv";
                R1 = R1.replaceAll("\"", "");

                contealu = files.obtenerDimension(R1);
                System.out.println(contealu);

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

                    System.out.println("Carga de Alumnos terminada");


                } catch (IOException e) {
                    System.out.println("Error");


                } finally {
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (IOException e2) {
                        System.out.println("Error");
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error");
            }


            //<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        } catch (Exception e) {
            System.out.println("Ocurrio un error con la ruta");
        }


    }

    void CargaCursos() {
        try {

            try {
                String R1 = ruta + "\\Cursos.csv";
                R1 = R1.replaceAll("\"", "");
                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;

                try {

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
                            int codigo;
                            String nombre;

                            try {
                                id = Integer.parseInt(contenido[0].trim());
                                if (correcto) {
                                    try {
                                        codigo = Integer.parseInt(contenido[1].trim());
                                        if (correcto) {
                                            try {
                                                nombre = contenido[2].trim();
                                                if (!IdRepetidoCurso(id)) {
                                                    if (correcto) {
                                                        try {
                                                            int aux = 0;
                                                            if (Cursos[100] == null) {
                                                                if (!IdRepetidoCurso(id)) {
                                                                    //codigoRepetidoCurso
                                                                    if (!CodigoRepetidoCurso(codigo)) {
                                                                        while (correcto && aux < 100) {
                                                                            if (Cursos[aux] == null) {
                                                                                Cursos[aux] = new Cursos(id, codigo, nombre);
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
                            }


                        }
                        contador++;
                    }

                    System.out.println("Carga de cursos terminada");


                } catch (IOException e) {
                    System.out.println("Error3");

                } finally {
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (IOException e2) {
                        System.out.println("Error2");
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error1");
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error con la ruta ");
        }


    }

    void Asignacion() {
        System.out.println("\n------Asignacion Alumnos------");
        try {
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            try {
                String R1 = ruta + "\\Notas.csv";
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

                            int idAlumno;
                            int idCurso;
                            int posCurso = -1;
                            int posAlumno = -1;

                            try {
                                idAlumno = Integer.parseInt(contenido[0].trim());
                                if (correcto) {
                                    try {
                                        idCurso = Integer.parseInt(contenido[1].trim());
                                        if (correcto) {
                                            boolean existe = false;
                                            //verificar que el alumno no este en el curso
                                            for (int i = 0; i < Cursos.length; i++) {
                                                if (Cursos[i] != null) {
                                                    if (Cursos[i].getId() == idCurso) {
                                                        posCurso = i;
                                                        existe = true;
                                                    }
                                                }
                                            }
                                            if (existe) {
                                                //vemos si el alumno exite
                                                boolean exisAlumno = false;
                                                for (int i = 0; i < Alumnos.length; i++) {
                                                    if (Alumnos[i] != null) {
                                                        if (Alumnos[i].getId() == idAlumno) {
                                                            posAlumno = i;
                                                            exisAlumno = true;
                                                        }
                                                    }
                                                }
                                                if (exisAlumno) {
                                                    boolean Noexiste = true;
                                                    Notas notasAlu[] = Cursos[posCurso].getAluNotas();
                                                    //ver si el alumno no esta registrado ya en el curso.
                                                    for (int i = 0; i < notasAlu.length; i++) {
                                                        if (notasAlu[i] != null) {
                                                            if (notasAlu[i].getAlumno().getId() == idAlumno) {
                                                                Noexiste = false;
                                                                break;
                                                            }
                                                        }
                                                    }

                                                    if (Noexiste) {
                                                        boolean cont = true;
                                                        int aux = 0;
                                                        if (Asignacion[299] == null) {
                                                            while (cont && contAsignacionAlumnos < 300) {
                                                                if (notasAlu[aux] == null) {
                                                                    notasAlu[aux] = new Notas(Alumnos[posAlumno]);
                                                                    cont = false;
                                                                    int aux2 = 0;
                                                                    boolean cont2 = true;
                                                                    while (cont2 && aux2 < Asignacion.length) {
                                                                        if (Asignacion[aux2] == null) {
                                                                            Asignacion[aux2] = new Asignacion(Alumnos[posAlumno], Cursos[posCurso]);
                                                                            cont2 = false;
                                                                        } else {
                                                                            aux2++;
                                                                        }
                                                                    }
                                                                    contAsignacionAlumnos++;
                                                                    //apartamamos espacion para otro alumno en este curso.
                                                                    Notas temp[] = new Notas[notasAlu.length + 1];
                                                                    for (int i = 0; i < notasAlu.length; i++) {
                                                                        temp[i] = notasAlu[i];
                                                                    }
                                                                    Cursos[posCurso].setAluNotas(temp);
                                                                } else {
                                                                    aux++;
                                                                }
                                                            }
                                                        } else {
                                                            System.out.println("\nerror en la linea " + (contador + 1) + ", Se llego al maximo de asignaciones.");
                                                            correcto = false;
                                                            contLectura = false;
                                                        }
                                                    } else {
                                                        System.out.println("\nerror en la linea " + (contador + 1) + ", el alumno ya esta registrado.");
                                                        correcto = false;
                                                    }

                                                } else {
                                                    System.out.println("\nerror en la linea " + (contador + 1) + ", no se encontro el alumno con el codigo proporcionado.");
                                                    correcto = false;
                                                }

                                            } else {
                                                System.out.println("\nerror en la linea " + (contador + 1) + ", no se encontro el curso con el codigo proporcionado.");
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

                    System.out.println("\nAsignacion terminada.\n");


                } catch (IOException e) {
                    System.out.println("error");

                } finally {
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (IOException e2) {
                        System.out.println("Error2");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error xd");
            }


            //<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        } catch (
                Exception e) {
            System.out.println("Ocurrio un error con la ruta");
        }

    }

    void AsigNotas() {
        try {

            System.out.println("\n------Carga Notas------");
            //En caso que se desee realizar otra carga puede realizarce.

            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            try {
                String R1 = ruta + "\\Notas.csv";;
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

                            int idAlumno;
                            int idCurso;
                            double nota;

                            try {
                                idAlumno = Integer.parseInt(contenido[0].trim());
                                if (correcto) {
                                    try {
                                        idCurso = Integer.parseInt(contenido[1].trim());
                                        if (correcto) {
                                            try {
                                                nota = Double.parseDouble(contenido[2].trim());
                                                if (nota >= 0 && nota < 101) {
                                                    boolean existAlumno = false;
                                                    boolean existCurso = false;
                                                    int posCurso = -1;
                                                    int posAlumno = -1;

                                                    //ver si existe el curso
                                                    for (int i = 0; i < Cursos.length; i++) {
                                                        if (Cursos[i] != null) {
                                                            if (Cursos[i].getId() == idCurso) {
                                                                posCurso = i;
                                                                existCurso = true;
                                                            }
                                                        }
                                                    }
                                                    //ver si existe el alumno.
                                                    for (int i = 0; i < Alumnos.length; i++) {
                                                        if (Alumnos[i] != null) {
                                                            if (Alumnos[i].getId() == idAlumno) {
                                                                posAlumno = i;
                                                                existAlumno = true;
                                                            }
                                                        }
                                                    }
                                                    if (existCurso) {
                                                        if (existAlumno) {
                                                            boolean alumnoasig = false;
                                                            //ahora como conocemos la posicion del curso, editamos la nota de cada alumno.
                                                            Notas temp[] = Cursos[posCurso].getAluNotas();
                                                            for (int i = 0; i < temp.length; i++) {
                                                                if (temp[i] != null) {
                                                                    if (temp[i].getAlumno().getId() == idAlumno) {
                                                                        alumnoasig = true;
                                                                    }
                                                                }
                                                            }
                                                            if (!alumnoasig) {
                                                                System.out.println("\nerror en la linea, el alumno no se encuentra asignado al curso, linea:" + (contador + 1));
                                                                correcto = false;
                                                            }else{
                                                                boolean asigNota = false;

                                                                for (int i = 0; i < temp.length; i++) {
                                                                    if (temp[i] != null) {
                                                                        if (temp[i].getAlumno().getId() == idAlumno && !temp[i].isAsignacion()) {
                                                                            temp[i].setNota(nota);
                                                                            temp[i].setAsignacion(true);
                                                                            asigNota = true;
                                                                        }
                                                                    }
                                                                }
                                                                if(!asigNota){
                                                                    System.out.println("\nerror en la linea,el alumno ya posee una nota asignada  , linea:" + (contador + 1));
                                                                    correcto = false;
                                                                }
                                                            }
                                                        } else {
                                                            System.out.println("\nerror en la linea,No se encontro ningun alumno con el codigo proporcionado  , linea:" + (contador + 1));
                                                            correcto = false;
                                                        }
                                                    } else {
                                                        System.out.println("\nerror en la linea,No se encontro ningun curso con el codigo proporcionado, linea: " + (contador + 1));
                                                        correcto = false;
                                                    }

                                                } else {
                                                    System.out.println("\nerror en la linea,problema con la nota, linea: " + (contador + 1));
                                                    correcto = false;
                                                }


                                            } catch (Exception e) {
                                                System.out.println("\nerror en la linea " + (contador + 1));
                                                correcto = false;
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("\nerror en la linea " + (contador + 1));;
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
                    mostrar();


                } catch (IOException e) {
                    System.out.println("error");
                    File f = new File("log.log"); // Creamos un objeto file
                    System.out.println("\nPuede ver los errores en : "+f.getAbsolutePath()+"\n");

                } finally {
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (IOException e2) {
                        System.out.println("otro error");
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

    public static Cursos buscar_curso(int id){
        for (int i = 0; i < Cursos.length; i++) {
            if (Cursos[i].getId()==id) {
                return Cursos[i];
            }
        }
        return null;
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

    boolean IdRepetidoCurso(int id) {
        for (int i = 0; i < Cursos.length; i++) {
            if (Cursos[i] != null) {
                if (Cursos[i].getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean CodigoRepetidoCurso(int codigo) {
        for (int i = 0; i < Cursos.length; i++) {
            if (Cursos[i] != null) {
                if (Cursos[i].getCodigo() == codigo) {
                    return true;
                }
            }
        }
        return false;
    }

    void MostrarDatos() {
        for (int i = 0; i < Cursos.length; i++) {
            if (Cursos[i] != null) {

                System.out.println("\nId: " + Cursos[i].getId());
                System.out.println("codigo: " + Cursos[i].getCodigo());
                System.out.println("nombre: " + Cursos[i].getNombre());
                System.out.println("Nota: " + Cursos[i].getAluNotas());


            }
        }
    }

    void MostrarAluuu(){
        for (int i = 0; i < Cursos.length; i++) {
            if (Cursos[i] != null) {
                //contar alumnos
                int alum = 0;
                Notas temp[] = Cursos[i].getAluNotas();
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] != null) {
                        if (temp[j].getAlumno() != null) {
                            alum++;
                        }
                    }
                }
                System.out.println(alum);
            }
        }
    }

    void mostrar() {
        for (int i = 0; i < Cursos.length; i++) {
            if (Cursos[i] != null) {
                System.out.println(" \ncurso " + Cursos[i].getId() + " " + Cursos[i].getNombre());
                Notas temp[] = Cursos[i].getAluNotas();
                if (temp[0] != null) {
                    System.out.println("Alumnos:");
                    for (int j = 0; j < temp.length; j++) {
                        if (temp[j] != null) {
                            System.out.println(" // " + temp[j].getAlumno().getId() + " // " + temp[j].getAlumno().getNombre() + " nota: " + temp[j].getNota());
                        }
                    }
                }
            }
        }
    }






}




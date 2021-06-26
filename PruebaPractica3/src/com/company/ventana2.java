package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana2 extends JFrame implements ActionListener {

    public JPanel panel;//declarar panel
    private JTextField cajatexto1;
    private JButton buscar, pie, barras, ordenamiento, regresar;
    private JLabel etiqueta, eti2, l1;
    static Cursos guardar;
    private Image imagen1;
    static int id_curso;

    public ventana2() {
        FondoPanel fondo1 = new FondoPanel();
        ////agregando esa imagen
        this.add(fondo1);
        this.setContentPane(fondo1);
        /////////pinche panel////////////
        panel = new JPanel(); //instanciando panel
        panel.setLayout(null);// desactivando el diseño
        panel.setBackground(Color.lightGray);
        this.getContentPane().add(panel); //agrega panel a ventana


        ///////////Agregando botones/////////////////////
        buscar = new JButton("BUSCAR");
        buscar.setBorder(BorderFactory.createLineBorder(Color.green));
        buscar.setBounds(300, 20, 140, 40);
        buscar.setBackground(Color.black);//color del fondo del boton
        buscar.setForeground(Color.white);//colo de la letra del texto
        buscar.setFont(new Font("cooper black", 0, 12));
        buscar.setVisible(true);//
        buscar.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(buscar);
        ////////////////////////
        pie = new JButton("GRAFICA POR SEXO");
        pie.setBorder(BorderFactory.createLineBorder(Color.yellow));
        pie.setBounds(70, 170, 150, 40);
        pie.setBackground(Color.black);//color del fondo del boton
        pie.setForeground(Color.white);//colo de la letra del texto
        pie.setFont(new Font("cooper black", 0, 12));
        pie.setVisible(true);//
        pie.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(pie);
        ////////////////////
        ////////////////////////
        barras = new JButton("GRAFICA POR EDAD");
        barras.setBorder(BorderFactory.createLineBorder(Color.yellow));
        barras.setBounds(70, 250, 150, 40);
     barras.setBackground(Color.black);//color del fondo del boton
        barras.setForeground(Color.white);//colo de la letra del texto
        barras.setFont(new Font("cooper black", 0, 12));
        barras.setVisible(true);//
        barras.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(barras);
        ////////////////////
        regresar = new JButton("REGRESAR");
        regresar.setBorder(BorderFactory.createLineBorder(Color.green));
        regresar.setBounds(300, 400, 140, 40);
        regresar.setBackground(Color.black);//color del fondo del boton
        regresar.setForeground(Color.white);//colo de la letra del texto
        regresar.setFont(new Font("cooper black", 0, 12));
        regresar.setVisible(true);//
        regresar.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(regresar);
        ////////////////////////

        ordenamiento = new JButton("GRAFICA DE NOTAS");
        ordenamiento.setBorder(BorderFactory.createLineBorder(Color.yellow));
        ordenamiento.setBounds(70, 370, 150, 40);
        ordenamiento.setBackground(Color.black);//color del fondo del boton
        ordenamiento.setForeground(Color.white);//colo de la letra del texto
        ordenamiento.setFont(new Font("cooper black", 0, 12));
        ordenamiento.setVisible(true);//
        ordenamiento.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(ordenamiento);
        ////////////////////////

        //////////////////////ETIQUETA////////////////////////////////
        etiqueta = new JLabel("GRAFICAS");// instanciamos una Jlabel con el nombre de etiqueta
        etiqueta.setBounds(5, 125, 300, 30);
        etiqueta.setForeground(Color.WHITE);//colo de la letra del texto
        etiqueta.setFont(new Font("cooper black", 0, 15));
        etiqueta.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(etiqueta);
        /////////////////////////////////////
        //////////////////////ETIQUETA////////////////////////////////
        eti2 = new JLabel("GRAFICA POR ORDENAMIENTO");// instanciamos una Jlabel con el nombre de etiqueta
        eti2.setBounds(5, 300, 500, 30);
        eti2.setForeground(Color.white);//colo de la letra del texto
        eti2.setFont(new Font("cooper black", 0, 15));
        eti2.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(eti2);


        ///////////////////////////caja de texto /////////////////////
        cajatexto1 = new JTextField();// instanciamos la caja de texto
        cajatexto1.setBackground(Color.pink);//color de caja de texto
        cajatexto1.setForeground(Color.black);//color de letra de caja de texto
        cajatexto1.setBounds(20, 20, 200, 30);//establece posicion de caja de texto
        cajatexto1.setVisible(true);
        this.add(cajatexto1);


        /////////////////////Elementos_ventana/////////////////////
        this.setTitle("*Practica 3*");
        this.setBounds(500, 150, 500, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    class FondoPanel extends JPanel {


        @Override
        public void paint(Graphics g) {

            imagen1 = new ImageIcon(getClass().getResource("/imagen/fondo1.gif")).getImage();
            g.drawImage(imagen1, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscar) {
            String id = cajatexto1.getText();
            if (id.equals("")) {


                JOptionPane.showMessageDialog(null, "ERROR ingrese los datos");
                System.out.println("precionaste el boton buscar");

            } else {

                JOptionPane.showMessageDialog(null, "se ha buscado correctamente");
                id_curso = Integer.parseInt(id);
                System.out.println("presionaste el boton");
                System.out.println("El id es: " + id_curso);
                //guardar = ventana.buscar_curso(id_curso);//llamando metodo para buscar curso de la clase ventana


            }
        }
        if (e.getSource() == pie) {
            System.out.println("presionaste boton grafica");


            VentanaPie grafpie = new VentanaPie();
            grafpie.setVisible(true);


        }
        if (e.getSource() == barras) {
            System.out.println("presionaste boton grafica");
            ventanaBarr barras = new ventanaBarr();
            barras.setVisible(true);

        }
        if (e.getSource() == regresar) {
            System.out.println("presionaste regresar");
            ventana v1 = new ventana();
            this.dispose();
        }


        if (e.getSource() == ordenamiento) {
            System.out.println("presionaste regresar");
            ventana_notas orde = new ventana_notas();
            orde.setVisible(true);
            this.dispose();

        }


    }
}


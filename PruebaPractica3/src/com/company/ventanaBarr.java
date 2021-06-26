package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaBarr extends JFrame implements ActionListener {


    public JPanel panel;//declarar panel
    private JTextField cajatexto1;
    private JButton boton, boton1;
    static JButton regresar;
    static JLabel etiqueta;
    private Image imagen1;


    public ventanaBarr() {



        /////////pinche panel////////////
        panel = new JPanel(); //instanciando panel
        panel.setLayout(null);// desactivando el diseño
        panel.setBounds(0,0,700,700);
        panel.setBackground(Color.PINK);
        this.getContentPane().add(panel); //agrega panel a ventana

        FondoPanel fondo1 = new FondoPanel();
        ////agregando esa imagen
        this.add(fondo1);
        this.setContentPane(fondo1);

        Grafica_barras nuevo= new Grafica_barras(fondo1);
        nuevo.start();


        //////////////////////ETIQUETA////////////////////////////////
        etiqueta = new JLabel("GRAFICA DE BARRAS");// instanciamos una Jlabel con el nombre de etiqueta
        etiqueta.setBounds(150, 5, 300, 30);
        etiqueta.setForeground(Color.white);//colo de la letra del texto
        etiqueta.setFont(new Font("cooper black", 0, 18));
        etiqueta.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(etiqueta);

        regresar = new JButton("REGRESAR");
        regresar.setBorder(BorderFactory.createLineBorder(Color.green));
        regresar.setBounds(700, 550, 140, 40);
        regresar.setBackground(Color.black);//color del fondo del boton
        regresar.setForeground(Color.white);//colo de la letra del texto
        regresar.setFont(new Font("cooper black", 0, 12));
        regresar.setVisible(true);//
        regresar.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        panel.add(regresar);

        /////////////////////Elementos_ventana/////////////////////
        this.setTitle("*Grafica de Barras ");
        this.setBounds(500, 350, 900, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    // las acciones que se pueden poner
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regresar) {
            System.out.println("presionaste regresar");
            ventana2 v2 = new ventana2();
            v2.setVisible(true);
            this.dispose();
        }
    }

    class FondoPanel extends JPanel {


        @Override
        public void paint(Graphics g) {

            imagen1 = new ImageIcon(getClass().getResource("/imagen/imagen4.gif")).getImage();
            g.drawImage(imagen1, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);

        }
    }
}



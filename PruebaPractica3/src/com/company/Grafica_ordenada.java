package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafica_ordenada extends JFrame implements ActionListener {
    static  JLabel tiempo,tipo,orden,pasos,velocidad;
    JLabel l1,l2,l3;
    static JPanel pp;
    JButton b1,b2,b4;
    static JButton b3;

    public  Grafica_ordenada(){
        ////////////panel
        pp=new JPanel();
        pp.setLayout(null);// desactivando el diseño
        pp.setBackground(Color.green);
        pp.setBounds(0,0,800,500);
        this.getContentPane().add(pp); //agrega panel a ventana

        tiempo=new JLabel();
        tiempo.setBounds(200, 10, 200, 30);//stablece posicion de etiqueta
        tiempo.setVisible(true);
        pp.add(tiempo);//añadir etiqueta a pane

        tipo=new JLabel();
        tipo.setBounds(20, 10, 200, 30);//stablece posicion de etiqueta
        tipo.setVisible(true);
        pp.add(tipo);//añadir etiqueta a pane

        velocidad=new JLabel();
        velocidad.setBounds(20, 40, 200, 30);//stablece posicion de etiqueta
        velocidad.setVisible(true);
        pp.add(velocidad);//añadir etiqueta a pane

        pasos=new JLabel();
        pasos.setBounds(200, 40, 200, 30);//stablece posicion de etiqueta
        pasos.setVisible(true);
        pp.add(pasos);//añadir etiqueta a pane

        orden=new JLabel();
        orden.setBounds(20, 70, 200, 30);//stablece posicion de etiqueta
        orden.setVisible(true);
        pp.add(orden);//añadir etiqueta a pane

//
//        //////////////////////Labels
//        l1=new JLabel();
//        l1.setText("Ingrese lo que desee buscar ");
//        l1.setBounds(20, 10, 350, 30);//stablece posicion de etiqueta
//        l1.setVisible(true);
//        p.add(l1);//añadir etiqueta a pane
//        /////////////agregando botoenes
//        b1= new JButton( "Bubble Sort ascendente");
//        b1.setBounds(550, 60, 180, 30);//stablece posicion de etiqueta
//        b1.setVisible(true);
//        p.add(b1);//añadir etiqueta a panel
//
//        b2= new JButton( "Bubble Sort descendente");
//        b2.setBounds(550, 110, 180, 30);//stablece posicion de etiqueta
//        b2.setVisible(true);
//        p.add(b2);//añadir etiqueta a panel

        b3= new JButton( "Regresar");
        b3.setBounds(550, 30, 180, 30);//stablece posicion de etiqueta
        b3.setVisible(true);
        b3.addActionListener(this);
        pp.add(b3);//añadir etiqueta a panel

        ///////////////////ventana
        this.setSize(800, 900);//tamaño de la ventana

        setTitle("[IPC] practica3");//titulo de la ventana
        setLocationRelativeTo(null);//localizacion de la venta




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b3){
            ventana_notas sc = new ventana_notas();
            sc.setVisible(true);
            this.dispose();

        }

//
//        } if (e.getSource()==b2 && e.getSource()==r1){
//
//
//        } if (e.getSource()==b1 && e.getSource()==r2){
//
//
//        } if (e.getSource()==b2 && e.getSource()==r2){
//
//        }if (e.getSource()==b1 && e.getSource()==r3){
//
//
//        } if (e.getSource()==b1 && e.getSource()==r3){
//
//        }



    }
}

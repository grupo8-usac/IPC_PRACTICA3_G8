package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Grafica_ordenada.pp;

public class ventana_notas extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JPanel p;
    JRadioButton r1,r2,r3;
    ButtonGroup grupos;
    JButton b1,b2,b3,b4;
    private Image imagen1;


    public  ventana_notas(){
//       FondoPanel fondo1 = new FondoPanel();
//        ////agregando esa imagen
//        this.add(fondo1);
//        this.setContentPane(fondo1);
        //////////panel
        p=new JPanel();
        p.setLayout(null);// desactivando el diseño
        p.setBackground(Color.blue);
        p.setBounds(0,0,800,700);
        this.getContentPane().add(p); //agrega panel a ventana


        //////////////////////Labels
        l1=new JLabel();
        l1.setText("Ingrese lo que desee buscar ");
        l1.setBounds(20, 10, 350, 30);//stablece posicion de etiqueta
        l1.setVisible(true);
        p.add(l1);//añadir etiqueta a panel
        this.add(l1);
        /////////////////Radio botones
        r1= new JRadioButton( "Velocidad lenta");
        r1.setBounds(20, 60, 160, 30);//stablece posicion de etiqueta
        r1.setVisible(true);
        r1.addActionListener(this);
        p.add(r1);//añadir etiqueta a panel

        r2= new JRadioButton( "Velocidad Media");
        r2.setBounds(200, 60, 160, 30);//stablece posicion de etiqueta
        r2.setVisible(true);
        r2.addActionListener(this);
        p.add(r2);//añadir etiqueta a panel

        r3= new JRadioButton( "Velocidad Rapida");
        r3.setBounds(380, 60, 160, 30);//stablece posicion de etiqueta
        r3.setVisible(true);
        r3.addActionListener(this);
        p.add(r3);//añadir etiqueta a panel
        ////////////agregando grupo de botones
        grupos=new ButtonGroup();
        grupos.add(r1);
        grupos.add(r2);
        grupos.add(r3);
        /////////////agregando botoenes
        b1= new JButton( "Bubble Sort ascendente");
        b1.setBounds(550, 60, 180, 30);//stablece posicion de etiqueta
        b1.setVisible(true);
        b1.addActionListener(this);
        p.add(b1);//añadir etiqueta a panel

        b2= new JButton( "Bubble Sort descendente");
        b2.setBounds(550, 110, 180, 30);//stablece posicion de etiqueta
        b2.setVisible(true);
        b2.addActionListener(this);
        p.add(b2);//añadir etiqueta a panel

        b3= new JButton( "Regresar");
        b3.setBounds(550, 160, 180, 30);//stablece posicion de etiqueta
        b3.setVisible(true);
        b3.addActionListener(this);
        p.add(b3);//añadir etiqueta a panel

        ///////////////////ventana
        this.setSize(800, 700);//tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("[IPC] practica3");//titulo de la ventana
        setLocationRelativeTo(null);//localizacion de la venta




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
        if (e.getSource()==b1 ){
            ValideRadios();
            Grafica_ordenada.orden.setText("Orden : Ascendetente");
            Grafica_ordenada.tipo.setText("Algoritmo : Bubble Sort");


        } if (e.getSource()==b2 ){
            ValideRadios1();
            Grafica_ordenada.orden.setText("Orden : Descendetente");
            Grafica_ordenada.tipo.setText("Algoritmo : Bubble Sort");

        }if (e.getSource()==b3 ){
            ventana2 as = new ventana2();
            as.setVisible(true);
            this.dispose();
        }




    }
    private void ValideRadios(){
        if (r1.isSelected()){
            Grafica_ordenada ordenada=new Grafica_ordenada();
            ordenada.setVisible(true);
            Grafica_edadBurbuja_ascendente nuevo3 =new Grafica_edadBurbuja_ascendente(pp,10);
            nuevo3.start();
            tiempo tiempo1=new tiempo();
            tiempo1.start();
            Grafica_ordenada.velocidad.setText("Velocidad : Baja");


        } if (r2.isSelected()){
            Grafica_ordenada ordenada=new Grafica_ordenada();
            ordenada.setVisible(true);
            Grafica_edadBurbuja_ascendente nuevo3 =new Grafica_edadBurbuja_ascendente(pp,6);
            nuevo3.start();
            tiempo tiempo1=new tiempo();
            tiempo1.start();
            Grafica_ordenada.velocidad.setText("Velocidad : Media");


        } if (r3.isSelected()){
            Grafica_ordenada ordenada=new Grafica_ordenada();
            ordenada.setVisible(true);
            Grafica_edadBurbuja_ascendente nuevo3 =new Grafica_edadBurbuja_ascendente(pp,1);
            nuevo3.start();
            tiempo tiempo1=new tiempo();
            tiempo1.start();
            Grafica_ordenada.velocidad.setText("Velocidad : Alta");


        }
    }
    private void ValideRadios1(){
        if (r1.isSelected()){
            Grafica_ordenada ordenada=new Grafica_ordenada();
            ordenada.setVisible(true);
            Grafica_edadBurbuja nuevo1=new Grafica_edadBurbuja(pp,10);
            nuevo1.start();
            tiempo tiempo1=new tiempo();
            tiempo1.start();
            Grafica_ordenada.velocidad.setText("Velocidad : Baja");

        } if (r2.isSelected()){
            Grafica_ordenada ordenada=new Grafica_ordenada();
            ordenada.setVisible(true);
            Grafica_edadBurbuja nuevo1=new Grafica_edadBurbuja(pp,6);
            nuevo1.start();
            tiempo tiempo1=new tiempo();
            tiempo1.start();
            Grafica_ordenada.velocidad.setText("Velocidad : Media");

        } if (r3.isSelected()){
            Grafica_ordenada ordenada=new Grafica_ordenada();
            ordenada.setVisible(true);
            Grafica_edadBurbuja nuevo1=new Grafica_edadBurbuja(pp,1);
            nuevo1.start();
            tiempo tiempo1=new tiempo();
            tiempo1.start();
            Grafica_ordenada.velocidad.setText("Velocidad : Alta");


        }
    }
}


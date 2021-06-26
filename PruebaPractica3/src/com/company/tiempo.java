package com.company;

public class tiempo extends Thread {
    static int segundos;
    static int minutos;

    public tiempo() {
        this.segundos=segundos;
        this.minutos = minutos;
    }

    public void run(){
        try {
            while (true) {

                // SLEEP DE UN MINUTO
                sleep(1000);
                segundos++;
                if (segundos == 0) {
                    segundos = 60;
                    minutos++;
                }
                Grafica_ordenada.tiempo.setText("Tiempo"+ minutos + ":" + segundos);//agregando el tiempo al Jlabel

            }
        } catch (Exception e) {

        }
    }

}
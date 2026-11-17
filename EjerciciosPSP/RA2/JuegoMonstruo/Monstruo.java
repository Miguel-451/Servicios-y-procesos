package com.ejemplo;

import java.util.Random;

public class Monstruo extends Thread {

    private Pantalla pantalla;

    public Monstruo(Pantalla pantalla) {
        this.pantalla = pantalla;
        setPriority(Thread.MIN_PRIORITY);
    }

    @Override
    public void run() {
        Random random = new Random();

        do {

            int posicion = random.nextInt(5); // 0 a 4

            pantalla.actualizarPosicion(posicion);

        }while(pantalla.juegoActivo());
    }
}

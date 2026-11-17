package com.ejemplo;

public class Renderizar extends Thread {

    private Pantalla pantalla;

    public Renderizar(Pantalla pantalla) {
        this.pantalla = pantalla;
        setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void run() {
        do {
            pantalla.mostrarPantalla();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }while (pantalla.juegoActivo());
    }
}
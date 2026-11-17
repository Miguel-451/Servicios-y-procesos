package com.ejemplo;

public class Evento extends Thread {

    private Pantalla pantalla;
    private int tipo;

    public Evento(Pantalla pantalla, int tipo) {
        this.pantalla = pantalla;
        this.tipo = tipo;
        setPriority(Thread.NORM_PRIORITY);
    }

    @Override
    public void run() {
        do {

            if (tipo == 1) {
                if(pantalla.actualizarVida()){
                    System.out.println("Nuevo Monstruo");
                    pantalla.resetearVida();
                }
            } else if (tipo == 2) {
                if(pantalla.actualizarPuntos()){
                    System.out.println("has ganado");
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }while (pantalla.juegoActivo());
    }
}

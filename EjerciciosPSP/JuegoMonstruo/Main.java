package com.ejemplo;

public class Main {
    public static void main(String[] args) {
        System.out.println("***** DEBES DE LLEGAR A 500 PUNTOS PARA GANAR *****");

        Pantalla pantalla = new Pantalla();

        Renderizar renderizar = new Renderizar(pantalla);

        Evento eventoVida = new Evento(pantalla, 1);
        Evento eventoPuntos = new Evento(pantalla, 2);

        Monstruo monstruo = new Monstruo(pantalla);

        renderizar.start();
        eventoVida.start();
        eventoPuntos.start();
        monstruo.start();
    }
}

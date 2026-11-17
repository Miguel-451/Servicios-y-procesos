package com.ejemplo;

public class Pantalla {

 private int vida = 100;
 private int puntos = 0;
 private int posicion = 0;
 boolean ganar;

 public synchronized boolean actualizarVida() {
  boolean senal = false;
  vida -= 10;
  if(vida <= 0){
   senal = true;
  }
  return senal;
 }

 public synchronized boolean actualizarPuntos() {
  ganar = false;
  puntos += 50;
  if(puntos > 500){
   ganar = true;
  }
  return ganar;
 }

 public synchronized void actualizarPosicion(int posicion) {
  this.posicion = posicion;
 }

 public synchronized void mostrarPantalla() {
  System.out.println("Vida: " + vida +
          " | Puntos: " + puntos +
          " | Posición monstruo: " + posicion);
 }

 public void resetearVida() {
  vida = 100;
 }

 public boolean juegoActivo() {
  boolean acabado = true;
  if(ganar){
   acabado = false;
  }
  return acabado;
 }
}
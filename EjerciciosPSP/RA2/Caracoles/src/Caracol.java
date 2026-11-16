import java.util.Random;

import static javax.sound.midi.MetaMessage.META;

public class Caracol implements Runnable {
    String nombre;
    //Caracol [] pista = new  Caracol[50];
    volatile int posicion = 0;
    final int META = 50;
    Random rand = new Random();
    public static volatile String ganador;

    Caracol(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
     while (posicion < META) {
         if(ganador == null) {
             try {
                 int avance = rand.nextInt(5) + 1;
                 int tiempo = rand.nextInt(500) + 100;
                 Thread.sleep(tiempo);
                 posicion = Math.min(posicion + avance, META);
                 mostrarPista();
                 if (posicion >= META) {
                     Carrera.declararGanador(nombre);
                     break;
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
                 break;
             }
         }else  {
             break;
         }
     }
    }

      void mostrarPista(){
         StringBuilder pista = new StringBuilder();
         pista.append(String.format("%-10s [", nombre)); // Nombre alineado
         for (int i = 0; i < META; i++) {
             if (i == posicion) {
                 pista.append("🐌"); // La posición del caracol
             } else {
                 pista.append("_"); // La pista vacía
             }
         }
         pista.append("] Meta!");
          System.out.println(pista.toString());
     }
}


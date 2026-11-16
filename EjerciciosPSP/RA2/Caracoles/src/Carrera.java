public class Carrera {
    public static void main(String[] args) {
        Thread c1 = new Thread(new Caracol("Rayo"));
        Thread c2 = new Thread(new Caracol("Turbo"));
        Thread c3 = new Thread(new Caracol("Lento"));
        Thread c4 = new Thread(new Caracol("Relámpago"));
        Thread c5 = new Thread(new Caracol("Babosa"));

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }


    public static synchronized void declararGanador(String nombre){
        if(Caracol.ganador == null){
            Caracol.ganador = nombre;
            System.out.println("¡El ganador es " + Caracol.ganador + "!");
        }
    }
}

public class Camarero implements Runnable{
    public static String numero;
    Mesa mesa;

    Camarero(Mesa mesa, String numero){
        this.mesa = mesa;
        this.numero = numero;
    }
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (mesa) {
                    while (!mesa.hayPlato() && !mesa.libreComandas()) {
                        mesa.wait();
                    }

                    if (mesa.hayPlato()) {
                        mesa.agarrarplato(numero);
                    }

                    if (mesa.libreComandas()) {
                        mesa.dejarComanda(new Comanda("Comanda"), numero);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

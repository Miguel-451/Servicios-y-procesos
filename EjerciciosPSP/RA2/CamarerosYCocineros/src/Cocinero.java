public class Cocinero implements Runnable{
    Mesa mesa;
    public String numero;

    Cocinero(Mesa mesa, String numero){
        this.mesa = mesa;
        this.numero = numero;
    }
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (mesa) {
                    while (!mesa.haycomanda() || !mesa.librePlatos()) {
                        mesa.wait();
                    }

                    mesa.agarrarcomanda(numero);
                    mesa.dejarPlato(new Plato("Plato"), numero);
                }
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

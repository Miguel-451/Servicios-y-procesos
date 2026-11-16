public class Mesa {
    Comanda [] comandas = new Comanda[2];
    Plato [] platos = new Plato[2];

    public boolean libreComandas() {
        boolean haysitio = false;
        for(int i = 0; i < comandas.length; i++){
            if(comandas[i] == null){
                haysitio = true;
                break;
            }
        }
        return haysitio;
    }

    public synchronized void dejarComanda(Comanda comanda, String numero) {
        for(int i = 0;i < comandas.length;i++){
            if(comandas[i] == null){
                comandas[i] = comanda;
                System.out.println(numero + " he dejado una comanda");
                this.notifyAll();
                break;
            }
        }
    }

    public boolean librePlatos() {
        boolean haysitio = false;
        for(int i = 0; i < platos.length; i++){
            if(platos[i] == null){
                haysitio = true;
                break;
            }
        }
        return haysitio;
    }

    public synchronized void dejarPlato(Plato plato, String numero) {
        for(int i = 0;i < platos.length;i++){
            if(platos[i] == null){
                platos[i] = plato;
                System.out.println(numero + " he dejado un plato");
                this.notifyAll();
                break;
            }
        }
    }

    public boolean haycomanda() {
        boolean haycomanda = false;
        for(int i = 0;i < comandas.length;i++){
            if(comandas[i] != null){
                haycomanda = true;
                break;
            }
        }
        return haycomanda;
    }

    public synchronized void agarrarcomanda(String numero) {
        for(int i = 0;i < comandas.length;i++){
            if(comandas[i] != null){
                comandas[i] = null;
                reposicionarArray(comandas);
                System.out.println(numero + " He cogido una comanda");
                this.notifyAll();
                break;
            }
        }
    }

    private void reposicionarArray(Object[] elementos) {
        int destino = 0;

        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null) {
                elementos[destino] = elementos[i];
                destino++;
            }
        }

        for (int i = destino; i < elementos.length; i++) {
            elementos[i] = null;
        }
    }

    public boolean hayPlato() {
        boolean haycomanda = false;
        for(int i = 0;i < platos.length;i++){
            if(platos[i] != null){
                haycomanda = true;
                break;
            }
        }
        return haycomanda;
    }

    public synchronized void agarrarplato(String numero) {
        for(int i = 0;i < platos.length;i++){
            if(platos[i] != null){
                platos[i] = null;
                reposicionarArray(platos);
                System.out.println(numero + " He agarrado un plato");
                this.notifyAll();
                break;
            }
        }
    }
}

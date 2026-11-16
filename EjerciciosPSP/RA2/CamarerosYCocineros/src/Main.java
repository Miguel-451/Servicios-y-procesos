public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();

        Cocinero cocinero1 = new Cocinero(mesa , "Cocinero1");
        Cocinero cocinero2 = new Cocinero(mesa , "Cocinero2");
        Cocinero cocinero3 = new Cocinero(mesa , "Cocinero3");
        Camarero camarero1 = new Camarero(mesa, "Camarero1");
        Camarero camarero2 = new Camarero(mesa, "Camarero2");
        Camarero camarero3 = new Camarero(mesa, "Camarero3");


        Thread t1 = new Thread(camarero1);
        Thread t2 = new Thread(camarero2);
        Thread t3 = new Thread(camarero3);
        Thread t4 = new Thread(cocinero1);
        Thread t5 = new Thread(cocinero2);
        Thread t6 = new Thread(cocinero3);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
import java.io.File;
import java.lang.ProcessBuilder;
import java.lang.Process;

public class Padre {

    public static void main(String[] args) throws Exception {

        File mensaje = new File("Mensaje.txt");
        File fi = new File("Respuesta.txt");

        System.out.println("Padre: fichero que voy a enviar:");
        System.out.println(mensaje.getAbsolutePath());

        ProcessBuilder pb = new ProcessBuilder("java", "Hijo", mensaje.getAbsolutePath(),fi.getAbsolutePath());

        pb.directory(new File("."));

        Process proceso = pb.start();

        int codigo = proceso.waitFor();

        System.out.println("El hijo ha terminado.");
        System.out.println("Código de salida: " + codigo);
    }
}


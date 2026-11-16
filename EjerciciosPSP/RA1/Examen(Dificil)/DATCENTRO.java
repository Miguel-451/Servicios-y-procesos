import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DATCENTRO {
    public static void main(String[] args) {
        File f = new File(args[0]);
if(f.exists()) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
        bw.write("Atocha-Sol");
    } catch (Exception e) {
        e.printStackTrace();
    }
}else System.out.println("El fichero Lugar.txt no existe");

    }
}

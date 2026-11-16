import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DATNORTEOESTE {
    public static void main(String[] args) {
        File f = new File(args[0]);

        if (f.exists()){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
                bw.write("9:00 am o 14:00");
            }catch (Exception e){
                e.printStackTrace();
            }
        } else System.out.println("El fichero HorasOeste.txt no existe");
    }
}

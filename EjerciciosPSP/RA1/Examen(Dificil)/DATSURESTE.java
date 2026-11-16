import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DATSURESTE {
    public static void main(String[] args) {
        File f = new File(args[0]);

        if(f.exists()) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
                bw.write("10:00 am o 16:00 am");
            }catch (IOException e){
                e.printStackTrace();
            }
        }else System.out.println("El fichero HoraEste.txt no existe");
    }
}

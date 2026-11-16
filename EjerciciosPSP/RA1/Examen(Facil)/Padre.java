import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Padre {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb1 = new ProcessBuilder("java","-cp", ".", "Hijo1");
        ProcessBuilder pb2 = new ProcessBuilder("java","-cp", ".", "Hijo2");
        ProcessBuilder pb3 = new ProcessBuilder("java","-cp", ".", "Hijo3");

        Process p1 = pb1.start();
        BufferedReader br1  = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String parte1 = br1.readLine();
        int codigo1 = p1.waitFor();
        System.out.println(parte1);
        br1.close();

        Process p2 = pb2.start();
        BufferedReader br2  = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        String parte2 = br2.readLine();
        System.out.println(parte2);
        int codigo2 = p2.waitFor();
        br2.close();

        Process p3 = pb3.start();
        BufferedReader br3  = new BufferedReader(new InputStreamReader(p3.getInputStream()));
        String parte3 = br3.readLine();
        System.out.println(parte3);
        int codigo3 = p3.waitFor();
        br3.close();

        System.out.println("codigo1:" + codigo1);
        System.out.println("codigo2: " + codigo2);
        System.out.println("codigo3: "+ codigo3);

        if(codigo1 == 0 && codigo2 == 0 && codigo3 == 0){
            System.out.println("Huevo Terminado");
            System.out.println("Saca el Huevo");
            System.out.println("Me como el huevo");
        }else{
            System.out.println("se me ha quemado el huevo");
        }
    }
}

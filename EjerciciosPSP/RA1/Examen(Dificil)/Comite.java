import javax.print.attribute.standard.PagesPerMinute;
import java.io.*;

public class Comite {
    public static void main(String[] args) throws IOException, InterruptedException {
        File f = new File("Lugar.txt");
        File f1 = new File("HorasOeste.txt");
        File f2 = new File("HoraEste.txt");
        File f3 = new File("Manifestacion.txt");

        ProcessBuilder pb1 = new ProcessBuilder("java","-cp",".","DATCENTRO",f.getAbsolutePath());
        ProcessBuilder pb2 = new ProcessBuilder("java","-cp",".", "DATNORTEOESTE",f1.getAbsolutePath());
        ProcessBuilder pb3 = new ProcessBuilder("java","-cp",".", "DATSURESTE",f2.getAbsolutePath());

        pb1.directory(new File("."));
        pb2.directory(new File("."));
        pb3.directory(new File("."));

        Process p1 = pb1.start();
        Process p2 = pb2.start();
        Process p3 = pb3.start();

        int codigo1 = p1.waitFor();
        int codigo2 = p2.waitFor();
        int codigo3 = p3.waitFor();



        if(codigo1 == 0 && codigo2 == 0 && codigo3 == 0 && f3.exists()){
            String lugar = "";
            String HoraOeste = "";
            String horasEste = "";
            System.out.println("Procedo a imprimir manifestacion");
            try(BufferedReader br = new BufferedReader(new FileReader(f))) {
                 lugar = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            try(BufferedReader br1 = new BufferedReader(new FileReader(f1))){
                 HoraOeste = br1.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            try(BufferedReader br2 = new BufferedReader(new FileReader(f2))){
                 horasEste = br2.readLine();

            }catch (Exception e){
                e.printStackTrace();
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(f3))){
                    bw.write("HORA Y LUGAR MANIFESTACION");
                    bw.write("\n");
                    bw.write("---------------");
                    bw.write("\n");
                    bw.write("Lugar de la manifestacion: " + lugar);
                    bw.write("\n");
                    bw.write("Horas a las que puede el oeste: " + HoraOeste);
                    bw.write("\n");
                    bw.write("Horas a las que puede el este: " + horasEste);
                    bw.write("\n");
                    bw.write("----------------");
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("Manifestacion Escrita");

        }else System.out.println("algo ha fallado con los procesos hijos o falta Manifestacion.txt");
    }
}

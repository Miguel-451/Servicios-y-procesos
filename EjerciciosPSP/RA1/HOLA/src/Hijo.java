    import java.io.*;

    public class Hijo {


        public static void main(String[] args) throws IOException{
            System.out.println("Procedo a encriptar el mensaje.");
            File f = new File(args[0]);
            File fi = new File(args[1]);
            char[] mensaje = llenarArray(f);
            char[] mensajeCifrado = cifrar(mensaje);

            creararchivo(mensajeCifrado, fi);


        }

        private static void creararchivo(char[] cifrado, File fi)throws IOException {
            FileWriter fw = new FileWriter(fi);
            for (char c : cifrado){
                fw.write(c);
            }
            fw.close();
        }

        private static char [] llenarArray(File f) throws IOException {

            int cantidad = 0;

            if(f.exists()){

                FileReader fic = new FileReader(f);

                while(fic.read() != -1){
                    cantidad++;
                }
                fic.close();
            }else{
                System.out.println("El fichero no existe");
                return new char[0];
            }

            char [] texto = new char[cantidad];

            FileReader fic = new FileReader(f);

            int i = 0;
            int caracter;

            while ((caracter = fic.read()) != -1){
                texto[i] = (char) caracter;
                i++;
            }
            fic.close();

            return texto;
        }
        private static char [] cifrar(char[] cifrado) {
            char[] cifradoD = new char[cifrado.length];

            for (int i = 0; i < cifrado.length; i++) {
                cifradoD[i] = cifrado[cifrado.length - 1 - i];
            }

            return cifradoD;

        }
    }

package soketProgramlama.temelInputOutput;

import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {

        //Finaly bloğunda writer kapatabilmek için try dışında tanımlama yapılır
        FileWriter writer=null;

        try{
            //sona true ekleyince dosyayı sıfırdan yazmıyor, varsa sona ekleme yapıyor
            writer = new FileWriter("FileWriterDosya.txt",true);

            writer.write("Enes Elma\n");
            writer.write("Rick and Morty");


        }finally {
            writer.close();
        }



    }
}

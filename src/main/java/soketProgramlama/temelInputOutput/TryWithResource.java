package soketProgramlama.temelInputOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) throws IOException {

        /*
        *   Filewriter closable interface ini implemente ettiği için
        *   bu teknikle writer.close() yazmasak bile dosya kapanır
        *   Bu özellik java 7 ile gelmiştir, öncesi için kullanılamaz
         */
        try(FileWriter writer1=new FileWriter("FileWriterDosya.txt",true);
            FileWriter writer2=new FileWriter("FileWriterDosya.txt",true);
            FileReader reader=new FileReader("FileReaderDosya.txt")){
            //aynı anda birden fazla Writer Reader da açılabilir

            int c,a=1;

            while ((c=reader.read())!=-1){
                writer1.write(c);
                System.out.println(a);
                a++;
            }
        }


    }
}

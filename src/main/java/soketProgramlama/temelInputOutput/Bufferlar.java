package soketProgramlama.temelInputOutput;

import java.io.*;

public class Bufferlar {
    public static void main(String[] args) throws IOException {

        //tekrar try with resource kullandık, .close kullanmaya gerek kalmadı
        try(BufferedReader bufReader=new BufferedReader(new FileReader("bufReader.txt"));
            BufferedWriter bufWriter=new BufferedWriter(new FileWriter("bufWriter.txt"))){

            String line;

            long bas=System.nanoTime();
            while ((line=bufReader.readLine())!=null){

                bufWriter.write(line+"\n");
            }
            long son=System.nanoTime();

            System.out.println(son - bas); //nano cinsinden geçen süre

        }


    }
}

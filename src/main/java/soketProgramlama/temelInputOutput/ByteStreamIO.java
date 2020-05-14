package soketProgramlama.temelInputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamIO {
    public static void main(String[] args) throws IOException {

        //Finaly bloğunda kapatabilmek için try dışında tanımlama yapılır
        FileOutputStream out=null;
        FileInputStream in=null;

        try{

            //müzik dosyasını kopyalıyoruz
            in=new FileInputStream("music.m4A");
            out=new FileOutputStream("musicCopy.m4a");

            int c;

            long bas=System.currentTimeMillis();
            while ((c=in.read())!=-1){
                out.write(c);
            }
            long son=System.currentTimeMillis();

            System.out.println(son-bas);

        }finally {
            out.close();
            in.close();
        }

    }
}

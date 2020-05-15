package soketProgramlama.temelThreadler.threadOlusturma;

public class ThreadOlusturma2 {
    public static void main(String[] args) {

        Thread printerX=new Thread(new Printer2("Ali"));
        Thread printerY=new Thread(new Printer2("Gudbettin Aliyev"));

        printerX.start();
        printerY.start();


    }
}

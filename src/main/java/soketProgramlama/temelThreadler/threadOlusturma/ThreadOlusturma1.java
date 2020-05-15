package soketProgramlama.temelThreadler.threadOlusturma;

public class ThreadOlusturma1 {
    public static void main(String[] args) {

        Printer1 printer=new Printer1("Ali");
        Printer1 printer1=new Printer1("Keykubat-----");

        printer.start();
        printer1.start();
    }
}

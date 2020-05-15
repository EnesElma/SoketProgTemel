package soketProgramlama.temelThreadler.threadOlusturma;

public class Printer1 extends Thread{
    private String isim;

    public Printer1(String isim){
        this.isim=isim;
    }

    @Override
    public void run() {
        for (int i=0;i<8;i++){
            System.out.println("merhaba "+isim);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

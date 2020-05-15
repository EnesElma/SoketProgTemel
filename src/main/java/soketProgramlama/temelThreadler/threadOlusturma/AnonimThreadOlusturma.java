package soketProgramlama.temelThreadler.threadOlusturma;

public class AnonimThreadOlusturma {
    public static void main(String[] args) {
        System.out.println("main thread çalışıyor");

        Thread print=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor");
                for (int i=0;i<5;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        print.start();
    }
}

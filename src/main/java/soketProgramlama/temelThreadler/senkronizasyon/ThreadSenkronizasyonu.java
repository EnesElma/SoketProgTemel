package soketProgramlama.temelThreadler.senkronizasyon;

public class ThreadSenkronizasyonu {
    private int count=0;
    public static void main(String[] args) {

        ThreadSenkronizasyonu ts=new ThreadSenkronizasyonu();
        ts.threadCalistir();
    }

    //synchronized kelimesi ile farklı threadlerin aynı anda count değişkenine
    //ulaşması engellenir, senkronizasyon sağlanır
    //fakat oluşan anahtar tüm classı kapsar, bu da probleme sebep olabilir bazen
    //bu sorun çoklu Lock kullanılarak çözülür
    public synchronized void arttir(){
        count++;
    }

    public void threadCalistir(){
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0;i<5000;i++) arttir();
                System.out.println("Thread 1 çalıştı");
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5000;i++) arttir();
                System.out.println("Thread 2 çalıştı");
            }
        });

        thread1.start();
        thread2.start();

        try {
            //join metodu ile thread 1-2 bitmeden diğer metodlara geçmez
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);

    }
}

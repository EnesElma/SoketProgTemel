package soketProgramlama.temelThreadler.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreOrnegi {

    private Semaphore sem=new Semaphore(3);   //aynı anda 3 thread çalıştırılabilir anlamında


    public void threadFonksiyonu(int id){

        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread çalışıyor. ID: "+id);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread çıkılıyor. ID: "+id);

        sem.release();
    }
}

package soketProgramlama.temelThreadler.semaphore;

/*
Semaphore ile birden çok threadin aynı anda çalışması sağlanır
 */

public class Main {
    public static void main(String[] args) {
        final SemaphoreOrnegi sm=new SemaphoreOrnegi();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                sm.threadFonksiyonu(1);
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                sm.threadFonksiyonu(2);
            }
        });

        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                sm.threadFonksiyonu(3);
            }
        });

        Thread thread4=new Thread(new Runnable() {
            @Override
            public void run() {
                sm.threadFonksiyonu(4);
            }
        });

        Thread thread5=new Thread(new Runnable() {
            @Override
            public void run() {
                sm.threadFonksiyonu(5);
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}

package soketProgramlama.temelThreadler.senkronizasyon;

import java.util.Scanner;

public class WaitNotify {

    public void thread1Fonksiyonu(){
        synchronized (this){
            System.out.println("Thread 1 çalışıyor");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread bir uyandı ve bitti");
        }
    }

    public void thread2Fonksiyonu(){
        Scanner scanner=new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this){
            System.out.println("Thread 2 çalışıyor, " +
                    "devam etmek için bir tuşa bas");

            scanner.nextLine();
            notify();
            System.out.println("uyan gardaş");
        }
    }


}

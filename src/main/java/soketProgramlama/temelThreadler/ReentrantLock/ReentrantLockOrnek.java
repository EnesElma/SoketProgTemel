package soketProgramlama.temelThreadler.ReentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockOrnek {

    private int say=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void arttir(){

        for(int i=0;i<10000;i++){
            say++;
        }
    }

    public void thread1Fonksiyonu(){
        lock.lock();
        System.out.println("lock=1");

        try {
            System.out.println("Thread 1 uyandırılmayı bekliyor");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 1 uyandırıldı ve çalışıyor");
        arttir();
        lock.unlock();

    }

    public void thread2Fonksiyonu(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner=new Scanner(System.in);


        lock.lock();
        System.out.println("lock=2  Thread 2 çalışıyor");
            arttir();

            scanner.nextLine();
            condition.signal();

        lock.unlock();


    }

    public void threadOver(){
        System.out.println("Say: "+say);
    }


}

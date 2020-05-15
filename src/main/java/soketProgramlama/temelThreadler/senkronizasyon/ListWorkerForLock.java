package soketProgramlama.temelThreadler.senkronizasyon;

import java.util.ArrayList;
import java.util.Random;

public class ListWorkerForLock {

    Random r=new Random();
    ArrayList <Integer> list1= new ArrayList<>();
    ArrayList <Integer> list2= new ArrayList<>();

    private final Object lock1=new Object();      //lock anahtarlar böyle oluşturulur
    private final Object lock2=new Object();

    public void lis1DegerEkle(){
        synchronized (lock1) {              //lock anahtarlar böyle kullanılır
            list1.add(r.nextInt(100));
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void lis2DegerEkle(){
        synchronized (lock2) {
            list2.add(r.nextInt(100));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void degerAta(){
        for (int i=0;i<1000;i++){
            lis2DegerEkle();
            lis1DegerEkle();
        }
    }

    public void calistir(){
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                degerAta();
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                degerAta();
            }
        });

        long bas=System.currentTimeMillis();
        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("list1: "+list1.size());
        System.out.println("list2: "+list2.size());

        long son=System.currentTimeMillis();

        System.out.println(son-bas);
    }




}

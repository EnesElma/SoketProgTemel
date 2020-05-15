package soketProgramlama.temelThreadler.threadHavuzlari;



//elimizde çok fazla thread varsa thread havuz kullanılır

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadHavuzlariVeExecutorService {
    public static void main(String[] args) {

        //aynı anda en fazla 2 thread çalışabilecek bir thread hafuzu oluşturuyoruz:
        ExecutorService executor= Executors.newFixedThreadPool(2);

        for (int i=0;i<10;i++){
            //submit()” metodu ile Processor tipindeki görevlerimizi
            // görev işleticiye (executor) ekleriz.
            if(i%2==0)
                executor.submit(new Worker2(String.valueOf(i),i));
            if(i%2==1)
            executor.submit(new Worker1(String.valueOf(i),i));

            //System.out.println("Submit çalıştı");
        }


        executor.shutdown();
        //“executor.shutdown()” Şunu ifade eder: Görev işleticiye (executorService)
        // yeni görev kabul etme ve mevcuttaki tüm görevler bittiğinde görev
        // işleticiyi sonlandır. Eğer bu çağrı yapılmazsa, yukarıdaki
        // program sonlanmayacak, yeni görevler beklemeye devam edecektir.



        try {
            //Threadlarin en fazla ne kadar süre çalışacağını belirtmek için await kullanılır
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        /*
        “ExecutorService” şöyle çalışmaktadır: Kendisine eklenen ilk
        görevi hemen işletmeye başlar. İkinci görev eklenir eklenmez
        hemen onu da işletmeye başlar. Ancak üçüncü görev geldiğinde önce
        havuzunda yer açılmasını bekler, yani ilk iki görevden birinin
        bitmesini. Bir diğer deyişle havuzdaki görevlerden biri tamamlanana
        kadar diğer görevler kuyrukta bekler. Ve tüm görevler bitene kadar
        bu şekilde devam eder.
         */



        //üstteki işlem kısmen de olsa aşağıdakine benzer
        //fakat havuzda yer açılınca hemen çalışması yönünden
        //aşağıdaki kodla farklıdır


        /*
        Thread t1=new Thread(new Worker("1",1));
        Thread t2=new Thread(new Worker("2",2));
        Thread t3=new Thread(new Worker("3",3));
        Thread t4=new Thread(new Worker("4",4));
        Thread t5=new Thread(new Worker("5",5));

        System.out.println("Bütün işler başladı");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t5.start();
        try {
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bütün işler bitti");
        */


    }
}

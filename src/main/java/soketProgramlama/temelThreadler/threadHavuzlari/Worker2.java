package soketProgramlama.temelThreadler.threadHavuzlari;

public class Worker2 implements Runnable{

    private String isim;
    private int taskID;

    public Worker2(String isim, int taskID) {
        this.isim = isim;
        this.taskID = taskID;
    }

    @Override
    public void run() {
        System.out.println("worker "+isim+ " "+taskID+ ". işe başladı");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("worker "+isim+ " "+taskID+ ". işe bitirdi......");

    }

}

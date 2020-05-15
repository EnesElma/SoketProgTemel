package soketProgramlama.temelThreadler.threadHavuzlari;

public class Worker1 implements Runnable{

    private String isim;
    private int taskID;

    public Worker1(String isim, int taskID) {
        this.isim = isim;
        this.taskID = taskID;
    }

    @Override
    public void run() {
        System.out.println("worker "+isim+ " "+taskID+ ". işe başladı");

        System.out.println("worker "+isim+ " "+taskID+ ". işe bitirdi......");

    }

}

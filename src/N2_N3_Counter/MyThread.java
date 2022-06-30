package N2_N3_Counter;

public class MyThread extends Thread {
    public static int countThread = 0;
    public String name = "Thread N";

    public MyThread() {
        this.countThread++;
        this.name += this.countThread;
        System.out.println(this.name + " создан");
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            Counter.increment();
        }
        System.out.println("Поток - выполнен");
    }

    @Override
    public void start() {
        super.start();
        System.out.println(this.name + " стартовал");
    }

}

package N2_Counter;

public class MyThread extends Thread {

    public MyThread() {
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            Counter.increment();
        }

    }
//
    @Override
    public void start() {
        super.start();

    }

}

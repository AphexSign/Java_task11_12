package N2_N3_Counter;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread[] myThreadsArr = new MyThread[100];

        for (int i = 0; i < 100; i++) {
            myThreadsArr[i] = new MyThread();
            System.out.println("Статус при создании:" + myThreadsArr[i].getState());
            System.out.println("=====================");
        }

        for (int j = 0; j < 100; j++) {
            myThreadsArr[j].start();
            System.out.println("Статус при старте:" + myThreadsArr[j].getState());

            myThreadsArr[j].join();
            System.out.println("=====================");
        }
        System.out.println(Counter.getCount());


    }
}

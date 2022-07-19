package N2_Counter;

import java.util.Arrays;
import java.util.Scanner;

public class MainThree {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        MyThread[] myThreadsArr = new MyThread[100];

//
        System.out.println("Нужна последовательность выполнения потоков? 0(НЕТ)   1(ДА)?");
        int bool = scanner.nextInt();

        //Лучше инициализировать потоки через Runnable, а не через свой класс Mythread
        for (int i = 0; i < 100; i++) {
            myThreadsArr[i] = new MyThread();
        }

        Arrays.stream(myThreadsArr).
                forEach(t -> {
                    t.start();
                   if(bool==1){
                       try {
                           t.join();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                    System.out.println(Counter.getCount());
                });
    }
}